package com.example.firebasev1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.heroes.view.*

class HeroAdapter(val mCtx: Context, val layoutResId: Int, val heroList: List<Hero>)
    : ArrayAdapter<Hero>(mCtx, layoutResId, heroList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater : LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(layoutResId, null)

        val textViewName = view.findViewById<TextView>(R.id.textViewName)
        val textViewID = view.findViewById<TextView>(R.id.textViewID)

        val hero = heroList[position]

        textViewName.text = hero.name
        textViewID.text = hero.id

        return view
    }
}
