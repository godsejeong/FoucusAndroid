package com.jjmin.focus.ui.splash

import android.content.Intent
import android.media.MediaPlayer.OnCompletionListener
import android.net.Uri
import android.os.Bundle
import com.jjmin.focus.R
import com.jjmin.focus.ui.base.BaseActivity
import com.jjmin.focus.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_splash.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf


class SplashActivity : BaseActivity() , SplashContract.View {

    override var initLayoutResourse : Int = R.layout.activity_splash

    private val presenter : SplashPresenter by inject{ parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val video: Uri = Uri.parse("android.resource://" + packageName + "/" + R.raw.lodding_splash_base)
        splashImg.setVideoURI(video)

        splashImg.setOnCompletionListener { startSplash() }

        splashImg.start()

//        splashImg.setAnimation(presenter.updateTheme())
//        splashImg.playAnimation()
//
//        splashImg.addAnimatorListener(object : Animator.AnimatorListener {
//            override fun onAnimationStart(animation: Animator?) {}
//
//            override fun onAnimationEnd(animation: Animator?) {
//                startSplash()
//            }
//
//            override fun onAnimationCancel(animation: Animator?) {}
//            override fun onAnimationRepeat(animation: Animator?) {}
//        })
    }

    override fun startSplash() {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
    }

}
