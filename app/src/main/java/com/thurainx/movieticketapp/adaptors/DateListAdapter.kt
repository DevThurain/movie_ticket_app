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

class DateListAdapter(val dayDelegate: DayDelegate, val context: Context) : RecyclerView.Adapter<DateListViewHolder>(){
    var mDayList = DateUtils().getNextTwoWeekDates()
    private var selectedPosition = 0
    var mHolder: DateListViewHolder? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_date,parent,false)
        return DateListViewHolder(view, dayDelegate)
    }

    override fun onBindViewHolder(holder: DateListViewHolder, position: Int) {
//        holder.itemView.tvDate.text = dateList[position]
//        if(position == selectedPosition){
//            holder.itemView.tvDate.setTextSize(TypedValue.COMPLEX_UNIT_PX, context.resources.getDimension(R.dimen.text_regular_2x_medium))
//            holder.itemView.tvDate.setTextColor(Color.WHITE)
//        }else{
//            holder.itemView.tvDate.setTextSize(TypedValue.COMPLEX_UNIT_PX, context.resources.getDimension(R.dimen.text_regular_2x))
//            holder.itemView.tvDate.setTextColor(ContextCompat.getColor(context,R.color.color_grey))
//        }
//        holder.itemView.tvDate.setOnClickListener {
//            dateDelegate.onTapDate(holder.itemView.tvDate.text.toString())
//            notifyItemChanged(selectedPosition)
//            selectedPosition = holder.absoluteAdapterPosition
//            notifyItemChanged(selectedPosition)
//
//        }
        mHolder = holder
        holder.bind(day = mDayList[position], isSelected = position == selectedPosition)
    }

    override fun getItemCount(): Int {
        return mDayList.size
    }

    fun updateData(index: Int) {
        mHolder?.let {
            if (selectedPosition >= 0)
                notifyItemChanged(selectedPosition)
            selectedPosition = index
            notifyItemChanged(selectedPosition)

        }


    }




}