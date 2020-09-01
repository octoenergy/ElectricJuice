package com.octopus.electricjuice.di

import com.octopus.electricjuice.App
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(
    modules = [
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        SingleActivityModule::class,
        PlatformModule::class
    ]
)
interface AndroidPlaygroundComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        fun build(): AndroidPlaygroundComponent
    }
}