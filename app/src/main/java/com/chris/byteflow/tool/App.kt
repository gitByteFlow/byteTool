package com.chris.byteflow.tool

import androidx.multidex.MultiDexApplication


class App : MultiDexApplication() {

    companion object {
        lateinit var instance: App
            private set
    }

    override fun onLowMemory() {
        super.onLowMemory()
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}