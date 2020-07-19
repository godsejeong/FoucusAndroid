package com.jjmin.focus

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.VideoView


class MyVideoView : VideoView {
    constructor(ctx: Context) : super(ctx)
    constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = View.getDefaultSize(0, widthMeasureSpec)
        val height = View.getDefaultSize(0, heightMeasureSpec)
        setMeasuredDimension(width, height)
    }
}