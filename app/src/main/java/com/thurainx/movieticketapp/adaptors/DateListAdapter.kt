package com.thurainx.movieticketapp.adaptors

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thurainx.movieticketapp.R
import com.thurainx.movieticketapp.data.vos.DayVO
import com.thurainx.movieticketapp.delegates.DayDelegate
import com.thurainx.movieticketapp.utils.DateUtils
import com.thurainx.movieticketapp.viewholders.DateListViewHolder

class DateListAdapter(val dayList: List<DayVO>,val dayDelegate: DayDelegate, val context: Context) : RecyclerView.Adapter<DateListViewHolder>(){
    var mDayList: List<DayVO> = dayList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_date,parent,false)
        return DateListViewHolder(view, dayDelegate)
    }

    override fun onBindViewHolder(holder: DateListViewHolder, position: Int) {

        holder.bind(day = mDayList[position])
    }

    override fun getItemCount(): Int {
        return mDayList.size
    }

    fun updateData(dayVOList: List<DayVO>) {
        mDayList = dayVOList
        notifyDataSetChanged()
    }




}