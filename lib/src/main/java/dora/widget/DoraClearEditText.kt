package dora.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.AttributeSet
import android.util.TypedValue
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.widget.AppCompatEditText
import dora.widget.clearedittext.R

open class DoraClearEditText @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null,
                                                       defStyleAttr: Int = 0)
    : AppCompatEditText(context, attrs, defStyleAttr), View.OnFocusChangeListener, TextWatcher {

    private var clearDrawable: Drawable? = null
    private var clearEdgeSize = dp2px(context, 10f)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val left = measuredWidth - clearDrawable!!.intrinsicWidth - clearEdgeSize
        val top = (measuredHeight - clearDrawable!!.intrinsicHeight) / 2
        clearDrawable!!.setBounds(
            left,
            top,
            left + clearDrawable!!.intrinsicWidth,
            top + clearDrawable!!.intrinsicHeight
        )
    }

    private fun dp2px(context: Context, dpVal: Float): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dpVal, context.resources.displayMetrics
        ).toInt()
    }

    init {
        val a = context.obtainStyledAttributes(attrs, R.styleable.DoraClearEditText)
        clearEdgeSize = a.getDimensionPixelSize(R.styleable.DoraClearEditText_dview_clearEdgeSize, clearEdgeSize)
        a.recycle()
        init()
    }

    private fun init() {
        isFocusableInTouchMode = true
        clearDrawable = compoundDrawables[2]
        if (clearDrawable == null) {
            clearDrawable = resources.getDrawable(R.drawable.dview_ic_input_clear)
        }
        setClearIconVisible(false)
        onFocusChangeListener = this
        addTextChangedListener(this)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (compoundDrawables[2] != null) {
            clearDrawable?.draw(canvas)
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (compoundDrawables[2] != null) {
            if (event.action == MotionEvent.ACTION_UP) {
                val left = compoundDrawables[2].bounds.left
                val top = compoundDrawables[2].bounds.top
                val right = compoundDrawables[2].bounds.right
                val bottom = compoundDrawables[2].bounds.bottom
                val touchable =
                    (event.x > left) &&
                            (event.x < right) &&
                            (event.y > top) &&
                            (event.y < bottom)
                if (touchable) {
                    this.setText("")
                }
            }
        }
        return super.onTouchEvent(event)
    }

    override fun onFocusChange(v: View?, hasFocus: Boolean) {
        if (hasFocus) {
            setClearIconVisible(!TextUtils.isEmpty(text))
        } else {
            setClearIconVisible(false)
        }
    }

    protected fun setClearIconVisible(visible: Boolean) {
        val left = compoundDrawables[0]
        val top = compoundDrawables[1]
        val right = if (visible) clearDrawable else null
        val bottom = compoundDrawables[3]
        setCompoundDrawables(left, top, right, bottom)
    }

    override fun onTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
        setClearIconVisible(s.isNotEmpty())
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

    override fun afterTextChanged(s: Editable?) {}
}