package com.octopus.electricjuice.di

import com.octopus.electricjuice.common.platform.LoggerImpl
import com.octopus.electricjuice.common.platform.Logger
import dagger.Binds
import dagger.Module

@Module
interface PlatformModule {

    @Binds
    fun logger(loggerImpl: LoggerImpl): Logger
}