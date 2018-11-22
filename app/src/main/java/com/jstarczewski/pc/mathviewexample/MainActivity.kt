package com.jstarczewski.pc.mathviewexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.jstarczewski.pc.mathview.src.MathView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mathView: MathView = findViewById<MathView>(R.id.mvTest) as MathView
        mathView.setText("'$\\M↖{→}=r↖{→}×F↖{→}, $[N*m]$ M↖{→}=rFsinα$ <br> $\\M↖{→}$ moment siły, $\\r↖{→}$ wektor przemieszczenia, $\\F↖{→}$ siła, $\\α$ kąt zawarty między wektorem przemieszczenia a siły'")


    }
}
