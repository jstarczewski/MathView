package com.jstarczewski.pc.mathviewexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.match_item.view.*

class RecyclerViewExampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_example)


        val equations: ArrayList<Equation> = arrayListOf()

        equations.add(Equation("Praca", "$\\W=F↖{→}◦∆r↖{→}$, $\\W=Frcosα$, $[N*m=J]$ <br> $\\W$ praca, $\\F↖{→}$ siła, $∆r↖{→}$ zmiana położenia, $\\α$ kąt zawarty między wektorem siły i przemieszczenia, $\\J$ dżul <br> $\\W=∫F↖{→}{dr↖{→}$ <br> $\\W=∫F↖{→}dr↖{→}$ całka siły po przemiszeczeni"))
        equations.add(Equation("Moc", "$\\P=W/t$, $[J/s=W]$, gdy $\\v↖{→}={const}↖{→}$ to $\\P=Fv$ <br> $\\P$ moc, $\\v$ prędkość, $\\F$ siła, jednostka mocy to Wat $\\W$"))
        equations.add(Equation("Energia kinetyczna", "$\\E_k={mv^2}/2$, $[kg * m^2/{s^2}=J]$ <br> $\\E_k$ energia kinetyczna, $\\m$ masa, $\\v↖{→}$ prędkość, jednostka energi to dżul $\\J$"))
        equations.add(Equation("Energia potencjalna", "$\\E_p=mgh$, $\\[kg*m^2/{s^2}=J]$, $\\R_z>>h$ <br> $\\E_p$ energia potencjalna, $\\m$ masa, $\\g↖{→}$ przyśpieszenie grawitacyjne, $\\h$ wysokość, $\\R_z$ promień ziemi, $\\J$ dżul"))
        equations.add(Equation("Energia potencjalna sprezystosci", "$\\E_{ps}={k*x^2}/2$, $\\[J]$ <br> $\\E_{ps}$ energia potencjalna sprężystości, $\\k$ współczynnik sprężystości $\\[N/m]$, $\\\\x$ wychylenie/wydłużenie sprężyny"))
        equations.add(Equation("Zasada zachowania energii", "W izolowanym układzie, całkowita energia mechaniczna nie zmienia sie."))

        findViewById<RecyclerView>(R.id.rvTest).apply {

            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = MathTestAdapter(equations)

        }



    }
}


class MathTestAdapter(private var equations: ArrayList<Equation>) : RecyclerView.Adapter<MathTestAdapter.ViewHolder>() {

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val tvEquationTitle = view.tvTitle!!
        val mvEquation = view.mvTest!!

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MathTestAdapter.ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.match_item, viewGroup, false)
        val holder: MathTestAdapter.ViewHolder = ViewHolder(view)
        holder.mvEquation.apply {
            textColor = "#black"
            backgroundColor = "white"
            textZoom = 70
        }
        return ViewHolder(view)


    }

    override fun getItemCount(): Int {
        return equations.size
    }

    override fun onBindViewHolder(viewHolder: MathTestAdapter.ViewHolder, position: Int) {

        viewHolder.tvEquationTitle.text = equations[position].title
        viewHolder.mvEquation.math = equations[position].equation
        viewHolder.mvEquation.update()


    }


}
