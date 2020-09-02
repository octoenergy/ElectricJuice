package com.octopus.electricjuice

import com.octopus.electricjuice.di.DaggerElectricJuiceComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<App> {
        return DaggerElectricJuiceComponent.factory()
            .create(this)
    }
}
