package com.jjmin.focus.ui.splash

import com.jjmin.focus.event.ThemeStatus
import com.jjmin.focus.event.TimeCheckEvent
import com.jjmin.focus.ui.base.BaseContract
import com.jjmin.focus.utils.SharedPreferencesUtil

class SplashPresenter(
    override val view: BaseContract.View,
    val timeCheckEvent: TimeCheckEvent,
    sharedPreferencesUtil: SharedPreferencesUtil
) : SplashContract.Presenter {

    override var updateCheck =
        if (sharedPreferencesUtil.getPreferences(
                "time",
                "hour",
                0
            ) as Int >= 6
        ) ThemeStatus.Night else ThemeStatus.Day

    override fun updateTheme(): String {
        return if (timeCheckEvent.getThemeStatus() != updateCheck) {
            when (updateCheck) {
                ThemeStatus.Night -> {
//                    밤인 테마
                    "splash_night_loading.json"
                }

                ThemeStatus.Day -> {
//                    낮인 테마
                    "splash_day_loading.json"
                }

                ThemeStatus.NotThing -> {
                    throw IllegalArgumentException("invalid time")
                }
            }
        } else {
            "splash_basic_loading.json"
        }
    }
}