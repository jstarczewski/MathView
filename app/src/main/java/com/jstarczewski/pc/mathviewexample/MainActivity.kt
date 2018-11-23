package com.jstarczewski.pc.mathviewexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jstarczewski.pc.mathview.src.TextAlign
import kotlinx.android.synthetic.main.match_item.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var equations: ArrayList<Equation> = arrayListOf<Equation>()

        for (i in 1..20) {
            equations.add(Equation("Test", "'$\\M↖{→}=r↖{→}×F↖{→}, $[N*m]$ M↖{→}=rFsinα$ <br> $\\M↖{→}$ moment siły, $\\r↖{→}$ wektor przemieszczenia, $\\F↖{→}$ siła, $\\α$ kąt zawarty między wektorem przemieszczenia a siły'"))
        }

        var viewManager = LinearLayoutManager(this)
        var mathTestAdapter = MathTestAdapter(equations)


        var recyclerView = findViewById<RecyclerView>(R.id.rvTest).apply {

            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = mathTestAdapter

        }


    }
}


class MathTestAdapter(var equations: ArrayList<Equation>) : RecyclerView.Adapter<MathTestAdapter.ViewHolder>() {

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        val tvEquationTitle = view.tvTitle
        val mvEquation = view.mvTest

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MathTestAdapter.ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.match_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return equations.size
    }

    override fun onBindViewHolder(viewHolder: MathTestAdapter.ViewHolder, position: Int) {

        viewHolder.tvEquationTitle.text = equations[position].title
        viewHolder.mvEquation.setDisplayedTextSizeInPercentagesBasedOnScreenDpiDensity(70)
        viewHolder.mvEquation.setTextAlign(TextAlign.LEFT)
        viewHolder.mvEquation.text(equations[position].equation)


    }


}
