package com.thurainx.movieticketapp.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.thurainx.movieticketapp.data.vos.ActorVO
import com.thurainx.movieticketapp.network.IMAGE_BASED_URL
import kotlinx.android.synthetic.main.view_holder_cast.view.*
import kotlinx.android.synthetic.main.view_holder_movie.view.*

class CastListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindData(actor: ActorVO) {
        Glide.with(itemView.context)
            .load(IMAGE_BASED_URL.plus(actor.profilePath))
            .centerCrop()
            .into(itemView.ivCastProfile)

        itemView.tvCastName.text = actor.name
    }
}