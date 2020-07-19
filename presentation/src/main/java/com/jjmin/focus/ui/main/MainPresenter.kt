package com.jjmin.focus.ui.main

import android.net.Uri
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jjmin.focus.R
import com.jjmin.focus.event.ThemeStatus
import com.jjmin.focus.event.TimeCheckEvent
import com.jjmin.focus.model.MainRecommentModel
import com.jjmin.focus.model.ModelImpl
import com.jjmin.focus.utils.SharedPreferencesUtil


class MainPresenter(
    override val view: MainContract.View,
    val timeEvent: TimeCheckEvent,
    val sharedPreferencesUtil: SharedPreferencesUtil
) : MainContract.Presenter {

    var swapList = ArrayList<ModelImpl>().apply {
        add(
            MainRecommentModel(
                "[Your Night / 당신의 밤] - Epic Gardener Sound",
                "에픽가드너Epic Gardener",
                "http://52.15.223.7:8080/thumbnails/maxresdefault.jpg",
                "http://52.15.223.7:8080/songs/Your_Night--_.mp3"
            )
        )

        add(
            MainRecommentModel(
                "[Your Night / 당신의 밤] - Epic Gardener Sound",
                "에픽가드너Epic Gardener",
                "http://52.15.223.7:8080/thumbnails/maxresdefault.jpg",
                "http://52.15.223.7:8080/songs/Your_Night--_.mp3"
            )
        )
    }

    var _dummyList = MutableLiveData<ArrayList<ModelImpl>>(arrayListOf())

    val dummyList: LiveData<ArrayList<ModelImpl>> get() = _dummyList


    init {
        _dummyList.value = swapList
    }

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

    fun updateList(position : Int){
//        swapList.clear()
//        dummyList.value!!.forEach {
//            it as MainRecommentModel
//            it.isSelete = false
//        }
//
//        var item = dummyList.value?.get(position)as MainRecommentModel
//        item.isSelete = true
//
//        _dummyList.value = swapList
//
//        Log.e("position", position.toString())

    }

}