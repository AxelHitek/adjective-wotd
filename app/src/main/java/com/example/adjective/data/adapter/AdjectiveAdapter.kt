package com.example.adjective.data.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.adjective.R
import com.example.adjective.data.model.Adjective

class AdjectiveAdapter(
    private val context: Context,
    private val adjectiveList: List<Adjective?>
) : BaseAdapter() {

    private class ViewHolder(row: View?) {
        var name: TextView
        var veryList: TextView
        var barelyList: TextView

        init {
            name = row?.findViewById(R.id.adjectiveName) as TextView
            barelyList = row?.findViewById(R.id.adjectiveBarely) as TextView
            veryList = row?.findViewById(R.id.adjectiveVery) as TextView
        }
    }

    override fun getView(position: Int, convertView: View?, p2: ViewGroup?): View {
        val view: View
        val viewHolder: ViewHolder
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.adjective, convertView, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        viewHolder.name.text = getItem(position).name
        viewHolder.veryList.text = getItem(position).veryList.toString()
        viewHolder.barelyList.text = getItem(position).barelyList.toString()

        return view
    }

    override fun getItem(position: Int): Adjective = adjectiveList.get(position)!!

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = adjectiveList.count()

}