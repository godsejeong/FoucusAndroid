package com.jjmin.focus.di

import com.jjmin.focus.ui.home.HomeContract
import com.jjmin.focus.ui.home.HomePresenter
import com.jjmin.focus.ui.splash.SplashContract
import com.jjmin.focus.ui.splash.SplashPresenter
import com.jjmin.focus.utils.SharedPreferencesUtil
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val myModule = module {
    single { SharedPreferencesUtil(androidContext()) }
}

val pagesModule = module {
    factory { (view : HomeContract.View) -> HomePresenter(view,get(),get()) }
    factory { (view : SplashContract.View) -> SplashPresenter(view,get(),get()) }
}
