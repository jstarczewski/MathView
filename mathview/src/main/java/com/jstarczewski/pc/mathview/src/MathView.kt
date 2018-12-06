package com.jstarczewski.pc.mathview.src

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import com.jstarczewski.pc.mathview.R
import kotlin.properties.Delegates

class MathView : WebView {

    private val path: String = "file:///android_asset/"

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

        if (attrs != null) {
            val math = context.obtainStyledAttributes(attrs, R.styleable.MathView)
            if (math.hasValue(R.styleable.MathView_text)) {
                this.text = math.getString(R.styleable.MathView_text)
            }
            math.recycle()
        }
    }

    var text: String? by Delegates.observable<String?>("") { _, old, new ->
        if (old != new)
            update()
    }

    var textAlign: TextAlign by Delegates.observable(TextAlign.CENTER) { _, old, new ->
        if (old != new)
            update()
    }


    var textColor: String by Delegates.observable("Black") { _, old, new ->
        if (old != new)
            update()
    }

    var backgroundColor: String by Delegates.observable("White") { _, old, new ->
        if (old != new)
            update()
    }

    var textZoom: Int = 100
        set(value) {
            setInitialScale((resources.displayMetrics.densityDpi) / 100 * value)
        }


    private fun update() = loadDataWithBaseURL(path,
            "<html><head><link rel='stylesheet' href='" + path + "jqmath-0.4.3.css'>" +
                    "<script src='" + path + "jquery-1.4.3.min.js'></script>" +
                    "<script src='" + path + "jqmath-etc-0.4.5.min.js'></script>" +
                    "</head><body><script>var s = '$text';" +
                    "M.parseMath(s);document.body.style.color = \"$textColor\";" +
                    "document.body.style.background = \"$backgroundColor\";" +
                    "document.body.style.textAlign = \"${textAlign.toString().toLowerCase()}\";" +
                    "document.write(s);</script></body>",
            "text/html", "UTF-8", null)
}

enum class TextAlign {
    CENTER, LEFT, RIGHT, JUSTIFY
}