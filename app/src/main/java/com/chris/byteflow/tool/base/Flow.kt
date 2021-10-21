package com.chris.byteflow.tool.base

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow


@FlowPreview
@ExperimentalCoroutinesApi
fun <T> Flow<T>.throttleFirst(duration: Long): Flow<T> = flow {
    var lastTime = 0L
    collect { upstream ->
        val currentTime = System.currentTimeMillis()
        val canEmit = currentTime - lastTime > duration
        if (canEmit) {
            lastTime = currentTime
            emit(upstream)
        }
    }
}