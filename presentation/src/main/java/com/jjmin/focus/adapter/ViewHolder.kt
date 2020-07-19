package com.jjmin.focus.adapter

import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.LayoutRes
import com.bumptech.glide.Glide
import com.jjmin.focus.R
import com.jjmin.focus.model.MainRecommentModel
import com.jjmin.focus.model.ModelImpl

//class MainRecommentViewHolder(
//    context: Context,
//    parent: ViewGroup,
//    @LayoutRes layout: Int
//) : BaseViewHolder<ModelImpl>(context, parent, layout) {
//
//    override fun View.onBind(item: ModelImpl) {
//
//        val thumbnailImg  = itemView.findViewById(R.id.mainRecommentImg) as ImageView
//        val songNameText = itemView.findViewById(R.id.musicNameTv) as TextView
//        val songArtistText  = itemView.findViewById(R.id.musicArtistTv) as TextView
//
//
//        item as MainRecommentModel
//
//        songNameText.text = item.musicName
//        songArtistText.text = item.musicArtist
//        Glide.with(itemView.context).load(item.thumbnail).into(thumbnailImg)
//
//    }
//
//
//
//}