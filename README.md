# MathView
Simple and light third-party view library written in `Kotlin` to ease displaying math formulas using [jqMath](https://mathscribe.com/author/jqmath.html). `MathView` is based on `WebView` and works similar to other math-rendering libraries, but it is compatible with Android DataBinding Library and allows user to customize the text a bit more.  

## About [jqMath](https://mathscribe.com/author/jqmath.html)
jqMath is a JavaScript module that makes it easy to put formatted mathematical expressions in web pages. It uses a simple TeX-like syntax, with MathML semantics and is roughly 5 times faster than MathJax (which is actually much bigger). jqMath is lightweight, fast and concise. It is standards-based and cross-browser, using MathML when available, else simple HTML and CSS, and avoiding pixel-map images. Thus pages load quickly, and expressions can be resized by the user, or easily passed to screen reading, graphing, or computer algebra software. 

## Building equations
The HTML source patterns that will result in math equations can be checked [here](https://mathscribe.com/author/jqmath.html). 

### Referencing characters
All HTML characters can be added by Unicode code point (decimal) reference.
```html
	&#x2297 = ⊗
```
There is no need to add every special character by [Unicode](https://www.w3schools.com/charsets/ref_utf_misc_symbols.asp) reference. The HTML characters can be copied straight into your code. Referencing is handy when you are entering characters with `EditText` widget.

### Kotlin String interpolation
When building equations in Kotlin sometimes double backslash is needed to escape Kotlin String Interpolation
```kotlin
	var math = "$\\F&#x2196{&#x2192}=ma_g$"
```
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
	implementation 'com.github.jstarczewski:MathView:0.4.0'
}
```
# Usage
`MathView` works nearly as `TextView`. It renders math equation with MathML semantics.

## In layout file 

```xml
	<com.jstarczewski.pc.mathview.src.MathView
        android:id="@+id/mvTest"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>
```

## In Activity

```kotlin
        mvTest.apply {
		textZoom = 120
        	textColor = Color.GREEN.toString()
    	    	backgroundColor = Color.WHITE
		text = "$\\F&#x2196{&#x2192}=ma_g$"
	}

```
## Set text directly in xml

While setting text directly in XML, remember to encode HTML special characters, for example : `& = &amp;`

```xml
	<com.jstarczewski.pc.mathview.src.MathView
        android:id="@+id/mvTest"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
	app:text="$F=mg$"/>
```


# Interface
There are currently five custom functions available for the user. I plan to refactor them to fit more in Kotlin style.

```kotlin
	// Apply properties
        var mathView : MathView = findViewById<MathView>(R.id.mvEditTextExample)
        mathView.apply {
            text = "$\\F=10$" // sets text
            textColor = "red" // sets text color, default value is "black"
	    backgroundColor = "blue" // sets background color, default value is "white"
        }
        mathView.textZoom = 120 // set text size based on pixel density, default value is 100 (%)
```

# Why jqMath and why I created this library ?
Back in 2016 I created an Android App which contained a lot of equations rendered with jqMath. I plan to rerelease the app and it is easier for me to write this simple library rather than convert all my equations to fit other rendering engine. `MathView` is my first Android library and writing it is a great fun for me. I'm currently learning Kotlin so if you see situations where I am not using Kotlin's full potential, feel free to contribute.



# Contributing
Feel free to contribute and report issues. Feedback appreciated!
