package com.jjmin.focus.adapter

import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.LayoutRes
import com.bumptech.glide.Glide
import com.jjmin.focus.R
import com.jjmin.focus.model.MainRecommentModel
import com.jjmin.focus.model.ModelImpl


class MainRecommentViewHolder(
    context: Context,
    parent: ViewGroup,
    @LayoutRes layout: Int
) : BaseViewHolder<ModelImpl>(context, parent, layout) {
    lateinit var songNameText: TextView
    lateinit var songArtistText: TextView
    lateinit var thumbnailImg: ImageView
    lateinit var statusImg: ImageView
    lateinit var container: FrameLayout

    override fun View.onBind(item: ModelImpl) {

        container = itemView.findViewById(R.id.thumbnailContainer) as FrameLayout

        thumbnailImg = itemView.findViewById(R.id.thumbnailImg) as ImageView
        statusImg = itemView.findViewById(R.id.startStatusImg) as ImageView

        songNameText = itemView.findViewById(R.id.musicNameTv) as TextView
        songArtistText = itemView.findViewById(R.id.musicArtistTv) as TextView

        item as MainRecommentModel

        songNameText.text = item.musicName
        songArtistText.text = item.musicArtist
        Glide.with(itemView.context).load(item.thumbnail).into(thumbnailImg)

    }

    fun show() {
        val parentHeight = (container.parent as View).height
        val scale: Float =
            ((parentHeight - (songNameText.height + songArtistText.height)) / container.height) * 1.2f
        container.pivotX = container.width * 0.5f
        container.pivotY = 0F
        container.animate().scaleX(scale)
            .withEndAction {
//                songNameText.visibility = View.VISIBLE
//                songArtistText.visibility = View.VISIBLE
//                statusImg.visibility = View.VISIBLE
                visibleAnimation(songNameText)
                visibleAnimation(songArtistText)
                visibleAnimation(statusImg)
            }
            .scaleY(scale).setDuration(200)
            .start()
    }

    fun hide() {
        container.animate().scaleX(1f).scaleY(1f)
            .setDuration(200)
            .start()
        songNameText.visibility = View.INVISIBLE
        songArtistText.visibility = View.INVISIBLE
        statusImg.visibility = View.INVISIBLE
    }

    fun visibleAnimation(view: View, isVisible: Boolean = true) {
        Log.e("isCheeck", isVisible.toString())
        if (isVisible) {
            view.alpha = 0f
            view.animate()
                .alpha(1.0f).duration = 400

            view.visibility = View.VISIBLE
        }
    }
}