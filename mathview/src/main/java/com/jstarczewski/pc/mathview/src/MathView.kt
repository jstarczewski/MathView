package com.jstarczewski.pc.mathview.src

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView

class MathView : WebView {

    private val path: String = "file:///android_asset/"
    private var mText = "Your equation"
    private var mBase: String = "<html><head><link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'><script src='" + path + "jquery-1.4.3.min.js'></script><script src='" + path + "jqmath-etc-0.4.5.min.js'></script></head><body><script>var s = $mText;M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>";

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        settings.javaScriptEnabled = true
        settings.cacheMode = WebSettings.LOAD_NO_CACHE
        Log.e("Init", "initialized")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
            setLayerType(View.LAYER_TYPE_HARDWARE, null)
        else
            setLayerType(View.LAYER_TYPE_SOFTWARE, null)
    }

    fun setText(text: String) {
        mText = text
        updateBase()
        this.loadDataWithBaseURL(path, mBase, "text/html", "UTF-8", null)

    }

    private fun updateBase() {
        mBase = "<html><head><link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'><script src='" + path + "jquery-1.4.3.min.js'></script><script src='" + path + "jqmath-etc-0.4.5.min.js'></script></head><body><script>var s = $mText;M.parseMath(s);document.body.style.fontSize = \"13pt\";document.body.style.textAlign = \"center\";document.write(s);</script></body>"
    }
}