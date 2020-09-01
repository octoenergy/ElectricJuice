package com.octopus.electricjuice.di

import com.octopus.electricjuice.common.SingleActivity
import com.octopus.electricjuice.common.platform.Announcer
import com.octopus.electricjuice.ElectricJuiceActivity
import com.octopus.electricjuice.common.platform.Navigator
import com.octopus.electricjuice.common.platform.AnnouncerImpl
import com.octopus.electricjuice.common.platform.NavigatorImpl
import com.octopus.electricjuice.githubrepositories.DetailsFragment
import com.octopus.electricjuice.githubrepositories.MainFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface SingleActivityModule {

    @SingleActivity
    @ContributesAndroidInjector(
            modules = [
                FragmentModule::class,
                ActivityScopedModule::class
            ]
    )
    fun androidPlaygroundActivity(): ElectricJuiceActivity
}

@Module
interface FragmentModule {

    @ContributesAndroidInjector
    fun mainFragment(): MainFragment

    @ContributesAndroidInjector
    fun detailsFragment(): DetailsFragment
}

@Module
interface ActivityScopedModule {

    @Binds
    fun navigator(navigatorImpl: NavigatorImpl): Navigator

    @Binds
    fun announcer(announcerImpl: AnnouncerImpl): Announcer
}
