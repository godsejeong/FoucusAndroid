package com.jjmin.focus

import android.app.Application
import android.content.Context
import com.jjmin.focus.di.myModule
import com.jjmin.focus.di.pagesModule
import com.jjmin.focus.di.timeModule
import net.danlew.android.joda.JodaTimeAndroid
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class FocusApplication : Application() {

    lateinit var context : Context

    override fun onCreate() {
        super.onCreate()

        context = this
        JodaTimeAndroid.init(this)
        startKoin {
            androidContext(this@FocusApplication)
            modules(listOf(pagesModule,timeModule,myModule))
        }
    }
}