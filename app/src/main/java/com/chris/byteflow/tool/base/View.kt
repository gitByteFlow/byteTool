package com.chris.byteflow.tool.base

import android.view.View
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


fun View.clicksFlow(
    scope: CoroutineScope,
    error: Throwable.() -> Unit = {},
    block: (view: View) -> Unit,
) =
    callbackFlow {
        setOnClickListener(this::trySend)
        awaitClose {
            setOnClickListener(null)
        }
    }
        .throttleFirst(1000)
        .onEach {
            runCatching { block(it) }.onFailure { error(it) }
        }
        .launchIn(scope)