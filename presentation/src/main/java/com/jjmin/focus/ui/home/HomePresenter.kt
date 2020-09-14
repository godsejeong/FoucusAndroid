package com.jjmin.focus.ui.home

import android.net.Uri
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.jjmin.focus.R
import com.jjmin.focus.event.ThemeStatus
import com.jjmin.focus.event.TimeCheckEvent
import com.jjmin.focus.model.MainRecommentModel
import com.jjmin.focus.model.ModelImpl
import com.jjmin.focus.utils.SharedPreferencesUtil
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit


class HomePresenter(
    override val view: HomeContract.View,
    val timeEvent: TimeCheckEvent,
    val sharedPreferencesUtil: SharedPreferencesUtil
) : HomeContract.Presenter {

    var swapList = ArrayList<ModelImpl>().apply {
        add(
            MainRecommentModel(
                "[Your Night / 당신의 밤] - Epic Gardener Sound",
                "에픽가드너Epic Gardener",
                "http://52.15.223.7:8080/thumbnails/maxresdefault_1.jpg",
                "http://52.15.223.7:8080/songs/Your_Night--_.mp3"
            )
        )

        add(
            MainRecommentModel(
                "[Your Night / 당신의 밤] - Epic Gardener Sound",
                "에픽가드너Epic Gardener",
                "http://52.15.223.7:8080/thumbnails/maxresdefault_1.jpg",
                "http://52.15.223.7:8080/songs/Your_Night--_.mp3"
            )
        )

        add(
            MainRecommentModel(
                "[Your Night / 당신의 밤] - Epic Gardener Sound",
                "에픽가드너Epic Gardener",
                "http://52.15.223.7:8080/thumbnails/maxresdefault_1.jpg",
                "http://52.15.223.7:8080/songs/Your_Night--_.mp3"
            )
        )

        add(
            MainRecommentModel(
                "[Your Night / 당신의 밤] - Epic Gardener Sound",
                "에픽가드너Epic Gardener",
                "http://52.15.223.7:8080/thumbnails/maxresdefault_1.jpg",
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

    var mainRecommentList = MutableLiveData<ArrayList<ModelImpl>>(arrayListOf())
    var subRecommentList = MutableLiveData<ArrayList<ModelImpl>>(arrayListOf())

    init{
        mainRecommentList.value = swapList
    }

    override fun loadUI() {
        view.loadUI()
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

    fun getAccessTime() {
        val accesshour = sharedPreferencesUtil.getPreferences("time", "hour", 0) as Int
        view.toastMessage("${accesshour}시에 처음으로 접속했습니다")
    }
}