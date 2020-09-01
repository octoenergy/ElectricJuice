package com.octopus.electricjuice.common.threading

actual val currentThreadName: String?
    get() = Thread.currentThread().name