package com.octopus.electricjuice.common.networking

import io.ktor.client.engine.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.features.json.*

actual val httpClientEngine: HttpClientEngine by lazy {
    OkHttp.create {
//        val networkInterceptor = HttpLoggingInterceptor().apply {
//            level = HttpLoggingInterceptor.Level.BODY
//        }
//        addNetworkInterceptor(networkInterceptor)
    }
}