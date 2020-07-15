package com.jjmin.focus.event

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

class TimeCheckEvent {

    fun getRealHour() : Int{
        var time = DateTime()
        val formatter = DateTimeFormat.forPattern("mm")
        return formatter.print(time).toInt()
    }

    fun getThemeStatus() : ThemeStatus {
        return when {
            getRealHour() < 6 -> {
                ThemeStatus.Day
            }
            getRealHour() >=6 -> {
                ThemeStatus.Night
            }
            else -> {
                ThemeStatus.NotThing
            }
        }
    }

}