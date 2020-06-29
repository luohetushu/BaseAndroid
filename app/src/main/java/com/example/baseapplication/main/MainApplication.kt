package com.example.baseapplication.main

import android.app.Application
import android.content.Context

class MainApplication: Application() {

    companion object {
        private var instance: MainApplication? = null
        fun getInstance() = instance!!
    }

    override fun onCreate() {
        super.onCreate()

        instance = this

    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
    }

}