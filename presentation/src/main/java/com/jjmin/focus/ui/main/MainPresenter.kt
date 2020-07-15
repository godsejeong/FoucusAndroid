package com.jjmin.focus.ui.main

import android.net.Uri
import com.jjmin.focus.R
import com.jjmin.focus.event.ThemeStatus
import com.jjmin.focus.event.TimeCheckEvent
import com.jjmin.focus.utils.SharedPreferencesUtil


class MainPresenter(
    override val view: MainContract.View,
    val timeEvent: TimeCheckEvent,
    val sharedPreferencesUtil: SharedPreferencesUtil
) : MainContract.Presenter {

    override fun updateTheme(): Int {
        return when (timeEvent.getThemeStatus()) {
            ThemeStatus.Night -> {
                R.drawable.ic_launcher_background
            }

            ThemeStatus.Day -> {
                R.drawable.ic_launcher_foreground
            }

            ThemeStatus.NotThing -> {
                throw IllegalArgumentException("invalid time")
            }
        }
    }

    override fun accessTime() {
        sharedPreferencesUtil.setPreferences("time", "hour", timeEvent.getRealHour())
    }

    override var videoUrl: Uri =
        Uri.parse("android.resource://" +  view.context.packageName + "/" + R.raw.main_animation_video)

    fun getAccessTime() {
        val accesshour = sharedPreferencesUtil.getPreferences("time", "hour", 0) as Int
        view.toastMessage("${accesshour}시에 처음으로 접속했습니다")
    }

}