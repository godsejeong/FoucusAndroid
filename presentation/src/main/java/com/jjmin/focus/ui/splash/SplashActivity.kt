package com.jjmin.focus.ui.splash

import android.animation.Animator
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.SurfaceHolder
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.jjmin.focus.R
import com.jjmin.focus.ui.base.BaseActivity
import com.jjmin.focus.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_splash.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf


class SplashActivity : BaseActivity() , SplashContract.View  {
    private var holder: SurfaceHolder? = null
    private var player: MediaPlayer? = null
    private var media: MediaPlayer? = null

    override var initLayoutResourse : Int = R.layout.activity_splash

    private val presenter : SplashPresenter by inject{ parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val video: Uri = Uri.parse("android.resource://" + packageName + "/" + R.raw.splash_basic_loading)
//         media = MediaPlayer()

//        val metrics = DisplayMetrics()
//        windowManager.defaultDisplay.getMetrics(metrics)
//        val params =
//            splashImg.layoutParams as ConstraintLayout.LayoutParams
//        params.width = metrics.widthPixels
//        params.height = metrics.heightPixels
//        params.leftMargin = 0
//        splashImg.layoutParams = params
//
//        splashImg.setVideoURI(video)
//
//        splashImg.setOnPreparedListener { mp: MediaPlayer ->
//            mp.setVideoScalingMode(MediaPlayer.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING)
//            mp.setScreenOnWhilePlaying(false)
//        }
//
//        splashImg.setOnCompletionListener { startSplash() }
//
//        splashImg.start()


        startSplash()

        splashImg.setAnimation("test.json")
        splashImg.playAnimation()

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
