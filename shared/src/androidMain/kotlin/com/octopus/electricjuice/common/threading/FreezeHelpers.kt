package com.octopus.electricjuice.common.threading

actual fun <T> T.freezey(): T = this

actual val <T> T.isFrozeny: Boolean
    get() = false

actual fun Any.ensureNeverFrozeny() {}