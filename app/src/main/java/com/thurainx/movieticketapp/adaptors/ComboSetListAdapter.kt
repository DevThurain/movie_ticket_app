package com.thurainx.movieticketapp.adaptors

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thurainx.movieticketapp.R
import com.thurainx.movieticketapp.viewholders.ComboSetViewHolder

class ComboSetListAdapter() : RecyclerView.Adapter<ComboSetViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComboSetViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_combo_set,parent,false)
        return ComboSetViewHolder(view)
    }

    override fun onBindViewHolder(holder: ComboSetViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 3
    }

}