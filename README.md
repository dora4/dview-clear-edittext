dview-clear-edittext
![Release](https://jitpack.io/v/dora4/dview-clear-edittext.svg)
--------------------------------

#### gradle依赖配置

```groovy
// 添加以下代码到项目根目录下的build.gradle
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
// 添加以下代码到app模块的build.gradle
dependencies {
    def latest_version = '1.0'
    implementation 'com.github.dora4:dview-clear-edittext:$latest_version'
}
```

#### 控件使用
```xml
        <dora.widget.DoraClearEditText
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:dview_clearEdgeSize="10dp"/>
```
