package com.jjmin.focus.ui.base

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.toast


abstract class BaseActivity : AppCompatActivity() , BaseContract.View{

    override lateinit var context: Context

    abstract var initLayoutResourse : Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(initLayoutResourse)
        context = this

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w: Window = window
            w.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }
    }

    override fun toastMessage(text: String) {
        toast(text)
    }
}