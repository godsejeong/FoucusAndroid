package com.jjmin.focus.ui.main

import android.net.Uri
import com.jjmin.focus.ui.base.BaseContract

interface MainContract{

    interface View : BaseContract.View {
        fun startVideo()
        fun settingPicker()
    }

    interface Presenter : BaseContract.Presenter{
        fun updateTheme() : Int
        fun accessTime()
        var videoUrl : Uri
    }

}