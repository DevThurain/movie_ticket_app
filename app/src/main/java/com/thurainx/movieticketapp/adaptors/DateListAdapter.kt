package com.thurainx.movieticketapp.adaptors

import android.content.Context
import android.graphics.Color
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.thurainx.movieticketapp.R
import com.thurainx.movieticketapp.delegates.DateDelegate
import com.thurainx.movieticketapp.viewholders.DateListViewHolder
import kotlinx.android.synthetic.main.viewholder_date.view.*

class DateListAdapter(val dateList: List<String>, val dateDelegate: DateDelegate, val context: Context) : RecyclerView.Adapter<DateListViewHolder>(){
    var selectedPosition = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_date,parent,false)
        return DateListViewHolder(view)
    }

    override fun onBindViewHolder(holder: DateListViewHolder, position: Int) {
        holder.itemView.tvDate.text = dateList[position]
        if(position == selectedPosition){
            holder.itemView.tvDate.setTextSize(TypedValue.COMPLEX_UNIT_PX, context.resources.getDimension(R.dimen.text_regular_2x_medium))
            holder.itemView.tvDate.setTextColor(Color.WHITE)
        }else{
            holder.itemView.tvDate.setTextSize(TypedValue.COMPLEX_UNIT_PX, context.resources.getDimension(R.dimen.text_regular_2x))
            holder.itemView.tvDate.setTextColor(ContextCompat.getColor(context,R.color.color_grey))
        }
        holder.itemView.tvDate.setOnClickListener {
            dateDelegate.onTapDate(holder.itemView.tvDate.text.toString())
            notifyItemChanged(selectedPosition)
            selectedPosition = holder.absoluteAdapterPosition
            notifyItemChanged(selectedPosition)

        }
    }

    override fun getItemCount(): Int {
        return dateList.size
    }



}