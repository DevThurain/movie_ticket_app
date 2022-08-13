package com.thurainx.movieticketapp.viewholders

import android.graphics.Color
import android.util.TypedValue
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.thurainx.movieticketapp.data.vos.DayVO
import com.thurainx.movieticketapp.R
import com.thurainx.movieticketapp.delegates.DayDelegate
import kotlinx.android.synthetic.main.viewholder_date.view.*

class DateListViewHolder(itemView: View,mDelegate: DayDelegate) : RecyclerView.ViewHolder(itemView) {
    var mDay: DayVO? = null
    init {
        itemView.setOnClickListener {
            mDay?.let {
                mDelegate.onTapDay(it)
            }
        }
    }


    fun bind(day: DayVO){
        itemView.tvDate.text = day.formatDay
        mDay = day
        if(day.isSelected){
            itemView.tvDate.setTextSize(TypedValue.COMPLEX_UNIT_PX, itemView.context.resources.getDimension(R.dimen.text_regular_2x_medium))
            itemView.tvDate.setTextColor(Color.WHITE)
        }else{
            itemView.tvDate.setTextSize(TypedValue.COMPLEX_UNIT_PX, itemView.context.resources.getDimension(R.dimen.text_regular_2x))
            itemView.tvDate.setTextColor(ContextCompat.getColor(itemView.context,R.color.color_grey))
        }
    }
}