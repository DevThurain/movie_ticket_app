package com.thurainx.movieticketapp.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.thurainx.movieticketapp.data.vos.SnackVO
import com.thurainx.movieticketapp.delegates.SnackDelegate
import kotlinx.android.synthetic.main.viewholder_combo_set.view.*

class ComboSetViewHolder(itemView: View, delegate: SnackDelegate) : RecyclerView.ViewHolder(itemView) {
    var mSnackVO: SnackVO? = null
    init {
        itemView.ivSnackAdd.setOnClickListener {
           mSnackVO?.let {
               delegate.onTapAddSnack(it)
           }
        }
        itemView.ivSnackRemove.setOnClickListener {
            mSnackVO?.let {
                delegate.onTapRemoveSnack(it)
            }
        }
    }

    fun bind(snack: SnackVO){
        mSnackVO = snack

        itemView.tvSnackTotal.text = snack.count.toString()
        itemView.tvComboSetPrice.text = "\$${(snack.price ?: 0) * snack.count}"
        itemView.tvSnackTitle.text = snack.name
        itemView.tvSnackDetail.text = snack.description

    }
}