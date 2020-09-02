package com.octopus.electricjuice.di

import android.app.Application
import com.octopus.electricjuice.App
import dagger.BindsInstance
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
interface ElectricJuiceComponent : AndroidInjector<App> {

    @Component.Factory
    interface Builder {
        fun create(@BindsInstance application: Application): ElectricJuiceComponent
    }
}