# MathView
Simple and light third-party view library written in `Kotlin` to ease displaying math formulas using [jqMath](https://mathscribe.com/author/jqmath.html). MathView works similar to other math-rendering libraries, but it allows user to customize the text a bit more. 

## About jqMath
jqMath is a JavaScript module that makes it easy to put formatted mathematical expressions in web pages. It uses a simple TeX-like syntax, with MathML semantics and is roughly 5 times faster than MathJax (which is actually much bigger). jqMath is lightweight, fast and concise. It is standards-based and cross-browser, using MathML when available, else simple HTML and CSS, and avoiding pixel-map images. Thus pages load quickly, and expressions can be resized by the user, or easily passed to screen reading, graphing, or computer algebra software. 

# Demo
![Demo RecyclerView](/MathViewGif.gif)

# Installation

Add below lines to app's build.gradle

```groovy
repositories {
	maven { url 'https://jitpack.io' }
}
```
```groovy
dependencies {
	implementation 'com.github.jstarczewski:MathView:0.2.0'
}
```
# Usage
`MathView` works nearly as `TextView`. It renders math equation with MathML semantics.

## In layout file: 

```xml
	<com.jstarczewski.pc.mathview.src.MathView
        android:id="@+id/mvTest"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>
```

### In Activity
```kotlin
        var mvTest: MathView = findViewById<MathView>(R.id.mvTest)
        mvTest.setTextZoom(120)
        mvTest.setTextColor(Color.GREEN.toString())
        mvTest.setBackgroundColor(Color.WHITE)
        mvTest.setText"$\\f\'(x)=\\limÎ	
```
