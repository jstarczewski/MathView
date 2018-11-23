package com.jstarczewski.pc.mathview.src

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView

class MathView : WebView {

    private val path: String = "file:///android_asset/"
    private val pathTest: String = ""
    private var mText = "Your equation"
    private var fontSize: Int = 13
    private var textAlign : String = TextAlign.CENTER.toString().toLowerCase()
    private var mBase: String = "<html><head><link rel='stylesheet' href='" + pathTest + "jqmath-0.4.3.css'><script src='" + pathTest + "jquery-1.4.3.min.js'></script><script src='" + pathTest + "jqmath-etc-0.4.5.min.js'></script></head><body><script>var s = $mText;M.parseMath(s);document.body.style.fontSize = \"$fontSize\";document.body.style.textAlign = \"$textAlign\";document.write(s);</script></body>";

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {

        settings.javaScriptEnabled = true
        settings.cacheMode = WebSettings.LOAD_NO_CACHE

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
            setLayerType(View.LAYER_TYPE_HARDWARE, null)
        else
            setLayerType(View.LAYER_TYPE_SOFTWARE, null)

        setInitialScale(resources.displayMetrics.densityDpi)

    }

    fun setText(text: String) {
        text(text)
    }

    fun text(text: String) {
        mText = text
        updateBase()
        this.loadDataWithBaseURL(path, mBase, "text/html", "UTF-8", null)

    }

    fun getText() : String = mText

    fun setDisplayedTextSizeInPercentagesBasedOnScreenDpiDensity(percentages: Int) {
        setInitialScale((resources.displayMetrics.densityDpi)/100*percentages)
    }
    fun setNonMathFontSize(size: Int) {
        fontSize = size
        updateBase()
    }

    fun setTextAlign(textAlign: TextAlign) {
        this.textAlign = textAlign.toString().toLowerCase()
        updateBase()
    }


    private fun updateBase() {
        mBase = "<html><head><link rel='stylesheet' href='" + pathTest + "jqmath-0.4.3.css'><script src='" + pathTest + "jquery-1.4.3.min.js'></script><script src='" + pathTest + "jqmath-etc-0.4.5.min.js'></script></head><body><script>var s = $mText;M.parseMath(s);document.body.style.fontSize = \"$fontSize\";document.body.style.textAlign = \"$textAlign\";document.write(s);</script></body>"
    }
}

enum class TextAlign {
    CENTER, LEFT, RIGHT, JUSTIFY
}

