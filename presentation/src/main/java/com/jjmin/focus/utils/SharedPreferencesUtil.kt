package com.jjmin.focus.utils

import android.content.Context

class SharedPreferencesUtil(val context : Context) {
    fun setPreferences(prefName : String = "pref",key : String,value : Any){
        var pref = context.getSharedPreferences("pref", Context.MODE_PRIVATE)
        var editter = pref.edit()

        when(value){
            is Int -> {
                editter.putInt(key,value).commit()
            }
            is Float -> {}
            is String -> {
                editter.putString(key,value).commit()
            }
            is Long -> {}
            is Boolean -> {}
        }
    }

    fun getPreferences(prefName : String = "pref",key : String,defaultValue : Any) : Any {
        var pref = context.getSharedPreferences("pref", Context.MODE_PRIVATE)

        return when(defaultValue){
            is Int -> {
                pref.getInt(key,0)
            }
            is Float -> {
                pref.getFloat(key,0F)
            }

            is String -> {
                pref.getString(key,"")
            }

            is Long -> {
                pref.getFloat(key,0F)
            }

            is Boolean -> {
                pref.getBoolean(key,false)
            }

            else ->{
                throw IllegalArgumentException("Variable recognition failed.")
            }
        }!!
    }


//    fun setHour(h : Int){
//        hourPref!!.edit().putInt("hour",h).commit()
//    }
//
//    fun getHour() : Int{
//        return hourPref!!.getInt("hour",0)
//    }

}