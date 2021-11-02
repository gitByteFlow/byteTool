package com.chris.byteflow.tool.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel(), LifecycleObserver {

    fun observe(lifecycle: Lifecycle) {
        lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    open fun onCreated() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    open fun onStart() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    open fun onStop() {

    }


}