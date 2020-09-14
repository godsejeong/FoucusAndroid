package com.jjmin.focus.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.constraintlayout.widget.ConstraintLayout
import com.jjmin.focus.R
import com.jjmin.focus.model.GlideApp
import com.jjmin.focus.model.MainRecommentModel
import com.jjmin.focus.model.ModelImpl


class MainRecommentViewHolder(
    context: Context,
    parent: ViewGroup,
    @LayoutRes layout: Int
) : BaseViewHolder<ModelImpl>(context, parent, layout) {
    lateinit var musicNameText: TextView
    lateinit var musicArtistText: TextView
    lateinit var thumbnailImg: ImageView
    lateinit var statusImg: ImageView
    lateinit var container: ConstraintLayout

    override fun View.onBind(item: ModelImpl) {

        item as MainRecommentModel

        container = itemView.findViewById(R.id.thumbnailContainer) as ConstraintLayout

        thumbnailImg = itemView.findViewById(R.id.thumbnailImg) as ImageView
        statusImg = itemView.findViewById(R.id.startStatusImg) as ImageView

        musicNameText = itemView.findViewById(R.id.musicNameTv) as TextView
        musicArtistText = itemView.findViewById(R.id.musicArtistTv) as TextView


        musicNameText.text = item.musicName
        musicArtistText.text = item.musicArtist

        val height = context.resources.getDimension(R.dimen.thumbnail_height).toInt()
        val width = context.resources.getDimension(R.dimen.thumbnail_width).toInt()

        GlideApp.with(context)
            .asBitmap()
            .override(width,height)
            .load(item.thumbnail)
            .into(thumbnailImg)
    }

    fun show() {
        val parentHeight = (container.parent as View).height
        val scale: Float =
            ((parentHeight - (musicNameText.height + musicArtistText.height)) / container.height) * 1.05f
        container.pivotX = container.width * 0.5f
        container.pivotY = 0F
        container.animate().scaleX(scale)
            .withEndAction {
                visibleAnimation(musicNameText)
                visibleAnimation(musicArtistText)
                visibleAnimation(statusImg)
            }
            .scaleY(scale).setDuration(400)
            .start()
    }

    fun hide() {
        container.animate().scaleX(1f).scaleY(1f)
            .setDuration(200)
            .start()
        musicNameText.visibility = View.INVISIBLE
        musicArtistText.visibility = View.INVISIBLE
        statusImg.visibility = View.INVISIBLE
    }

    fun visibleAnimation(view: View, isVisible: Boolean = true) {
        if (isVisible) {
            view.alpha = 0f
            view.animate()
                .alpha(1.0f).duration = 600

            view.visibility = View.VISIBLE
        }
    }
}