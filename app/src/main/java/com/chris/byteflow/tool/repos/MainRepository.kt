package com.chris.byteflow.tool.repos

import android.app.Application
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepository @Inject constructor(
    private val ctx: Application,
) {

}
