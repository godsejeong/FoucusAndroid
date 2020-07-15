package com.jjmin.focus.ui.main

import android.content.Context
import android.media.MediaPlayer.OnPreparedListener
import android.net.Uri
import android.os.Bundle
import com.jjmin.focus.R
import com.jjmin.focus.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_splash.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf


class MainActivity : BaseActivity() , MainContract.View {

    override var initLayoutResourse: Int = R.layout.activity_main

    private val presenter : MainPresenter by inject{ parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter.accessTime()

        startVideo()

        accessBtn.onClick {
            presenter.getAccessTime()
        }

        mainImg.setBackgroundResource(presenter.updateTheme())

    }

    fun startVideo(){
        animationVideo.setVideoURI(presenter.videoUrl)
        animationVideo.start()
        animationVideo.setOnPreparedListener { mp -> mp.isLooping = true }
    }
}
