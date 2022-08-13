package com.thurainx.movieticketapp.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.thurainx.movieticketapp.R
import com.thurainx.movieticketapp.data.vos.TimeSlotVO
import com.thurainx.movieticketapp.delegates.TimeSlotDelegate
import kotlinx.android.synthetic.main.viewholder_time.view.*

class TimeListViewHolder(itemView: View, timeSlotDelegate: TimeSlotDelegate) : RecyclerView.ViewHolder(itemView) {
    var mTimeSlotVO : TimeSlotVO? =null
    init {
        itemView.setOnClickListener {
            mTimeSlotVO?.let {
                timeSlotDelegate.onTapTimeSlot(it)
            }
        }
    }
    fun bind(timeSlot: TimeSlotVO) {
        mTimeSlotVO = timeSlot
        itemView.tvTime.text = timeSlot.startTime

        if(timeSlot.isSelected){
            itemView.flTime.background = itemView.context.getDrawable(R.drawable.background_radio_selected)
            itemView.tvTime.setTextColor(itemView.context.getColor(R.color.white))
        }else{
            itemView.flTime.background = itemView.context.getDrawable(R.drawable.background_radio_regular)
            itemView.tvTime.setTextColor(itemView.context.getColor(R.color.black))
        }
    }

}