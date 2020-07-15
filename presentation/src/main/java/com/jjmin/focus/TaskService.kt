package com.jjmin.focus

import android.app.Service
import android.content.Intent
import android.os.IBinder
import org.jetbrains.anko.toast

class TaskService : Service() {
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onTaskRemoved(rootIntent: Intent?) {
        super.onTaskRemoved(rootIntent)
        toast("앱을 종료했습니다")
    }
}