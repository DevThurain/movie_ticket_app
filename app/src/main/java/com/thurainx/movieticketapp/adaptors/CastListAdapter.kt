package com.thurainx.movieticketapp.adaptors

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thurainx.movieticketapp.R
import com.thurainx.movieticketapp.viewholders.CastListViewHolder

class CastListAdapter() : RecyclerView.Adapter<CastListViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_cast,parent,false)
        return CastListViewHolder(view)
    }

    override fun onBindViewHolder(holder: CastListViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 5
    }

}