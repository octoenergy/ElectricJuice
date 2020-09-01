package com.octopus.electricjuice.common.platform

import android.util.Log
import javax.inject.Inject

class LoggerImpl @Inject constructor() : Logger {

    override fun log(message: String) {
        Log.v("Playground", message)
    }
}