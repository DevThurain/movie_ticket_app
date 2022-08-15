package com.thurainx.movieticketapp.adaptors

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thurainx.movieticketapp.R
import com.thurainx.movieticketapp.data.vos.DayVO
import com.thurainx.movieticketapp.data.vos.SnackVO
import com.thurainx.movieticketapp.delegates.SnackDelegate
import com.thurainx.movieticketapp.viewholders.ComboSetViewHolder

class ComboSetListAdapter(val snackDelegate: SnackDelegate) : RecyclerView.Adapter<ComboSetViewHolder>(){
    var mSnackList: List<SnackVO> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComboSetViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_combo_set,parent,false)
        return ComboSetViewHolder(view,snackDelegate)
    }

    override fun onBindViewHolder(holder: ComboSetViewHolder, position: Int) {
        if(mSnackList.isNotEmpty()){
            holder.bind(mSnackList[position])
        }
    }

    override fun getItemCount(): Int {
        return mSnackList.size
    }

    fun setNewData(snackList: List<SnackVO>) {
        mSnackList = snackList
        notifyDataSetChanged()
    }

}