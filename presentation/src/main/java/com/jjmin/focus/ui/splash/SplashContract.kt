package com.jjmin.focus.ui.splash

import com.airbnb.lottie.LottieAnimationView
import com.jjmin.focus.event.ThemeStatus
import com.jjmin.focus.ui.base.BaseContract

interface SplashContract {

    interface View : BaseContract.View{
        fun startSplash()
    }

    interface Presenter : BaseContract.Presenter{
        fun updateTheme() : String
        var updateCheck : ThemeStatus
    }

}