package com.jstarczewski.pc.mathviewexample

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_text_example.*

class EditTextExampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_text_example)

        mvEditTextExample.textZoom = 70


        mvEditTextExample.textC

        btShowEquation?.setOnClickListener {

            mvEditTextExample.text = etEquation.text.toString()

        }
        btShowRecyclerView?.setOnClickListener {
            startActivity(Intent(this, RecyclerViewExampleActivity::class.java))
        }
    }
}
