dview-clear-edittext
![Release](https://jitpack.io/v/dora4/dview-clear-edittext.svg)
--------------------------------
![Uploading DORA视图 流体吸收者.jpeg…]()

##### 卡名：Dora视图 Clear EditText 
###### 卡片类型：效果怪兽
###### 属性：风
###### 星级：3
###### 种族：鸟兽族
###### 攻击力/防御力：800/1200
###### 效果：此卡不会因为对方卡的效果而破坏，并可使其无效化。此卡攻击里侧守备表示的怪兽时，若攻击力高于其守备力，则给予对方此卡原攻击力的伤害，并抽一张卡。一回合一次，可让对方场地上一只怪兽回到手牌中，发送此效果的场合，此卡不能攻击。

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
