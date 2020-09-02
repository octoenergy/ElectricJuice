package com.octopus.electricjuice.di

import com.octopus.electricjuice.common.ResourceProviderImpl
import com.octopus.electricjuice.common.platform.LoggerImpl
import com.octopus.electricjuice.common.platform.Logger
import com.octopus.electricjuice.common.resources.ResourceProvider
import dagger.Binds
import dagger.Module

@Module
interface PlatformModule {

    @Binds
    fun logger(loggerImpl: LoggerImpl): Logger
}