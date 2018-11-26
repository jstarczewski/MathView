package com.jstarczewski.pc.mathview.src

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.util.AttributeSet
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView

class MathView : WebView {

    private val path: String = "file:///android_asset/"
    private var text = " "
    private var percentagesSize = 100
    private var textAlign: String = TextAlign.CENTER.toString().toLowerCase()
    private var textColor: String = ""
    private var backgroundColor: String = ""

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    @SuppressLint("SetJavaScriptEnabled")
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        with(settings) {
            loadWithOverviewMode = true
            javaScriptEnabled = true
            cacheMode = WebSettings.LOAD_NO_CACHE
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
            setLayerType(View.LAYER_TYPE_HARDWARE, null)
        else
            setLayerType(View.LAYER_TYPE_SOFTWARE, null)
        setInitialScale(resources.displayMetrics.densityDpi)

    }

    fun setText(text: String) {
        this.text = text
        update()
    }

    fun setTextSizeBasedOnDpiDensity(percentages: Int) {
        percentagesSize = percentages
        setInitialScale((resources.displayMetrics.densityDpi) / 100 * percentagesSize)
    }

    fun setTextAlign(textAlign: TextAlign) {
        this.textAlign = textAlign.toString().toLowerCase()
        update()
    }

    fun setBackgroundColor(color: String) {
        backgroundColor = color
        update()
    }

    fun setTextColor(color: String) {
        textColor = color
        update()
    }

    fun getText(): String = text

    private fun update() = loadDataWithBaseURL(path,
            "<html><head><link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>" +
                    "<script src='" + path + "jquery-1.4.3.min.js'></script>" +
                    "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>" +
            "</head><body><script>var s = '$text';" +
            "M.parseMath(s);document.body.style.color = \"$textColor\";" +
                    "document.body.style.background = \"$backgroundColor\";" +
            "document.body.style.textAlign = \"$textAlign\";" +
            "document.write(s);</script></body>",
            "text/html", "UTF-8", null)
}

enum class TextAlign {
    CENTER, LEFT, RIGHT, JUSTIFY
}