package com.jstarczewski.pc.mathviewexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.jstarczewski.pc.mathview.src.MathView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mathView: MathView = findViewById<MathView>(R.id.mvTest) as MathView

        mathView.setText("'$\\x(t)=Asin(ωt+ϕ_o)[m]$, $\\x_{max}=A$ <br> $\\x(t)$ położenie od czasu, $\\A$ amplituda, $\\ω$ częstość kołowa, $\\t$ czas, $\\ϕ_o$ przesunięcie początkowe'")


    }
}
