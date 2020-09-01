package com.octopus.electricjuice.common.threading

import platform.Foundation.NSThread

actual val currentThreadName: String?
    get() = NSThread.currentThread().debugDescription