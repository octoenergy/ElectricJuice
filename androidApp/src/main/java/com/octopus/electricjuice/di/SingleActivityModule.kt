package com.octopus.electricjuice.di

import com.octopus.electricjuice.common.SingleActivity
import com.octopus.electricjuice.common.platform.Announcer
import com.octopus.electricjuice.ElectricJuiceActivity
import com.octopus.electricjuice.common.ResourceProviderImpl
import com.octopus.electricjuice.common.platform.Navigator
import com.octopus.electricjuice.common.platform.AnnouncerImpl
import com.octopus.electricjuice.common.platform.NavigatorImpl
import com.octopus.electricjuice.common.resources.ResourceProvider
import com.octopus.electricjuice.githubrepositories.DetailsFragment
import com.octopus.electricjuice.githubrepositories.MainFragment
import com.octopus.electricjuice.onboarding.OnboardingPage
import com.octopus.electricjuice.onboarding.OnboardingPageFragment
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
    fun electricJuiceActivity(): ElectricJuiceActivity
}

@Module
interface FragmentModule {

    @ContributesAndroidInjector
    fun mainFragment(): MainFragment

    @ContributesAndroidInjector
    fun detailsFragment(): DetailsFragment

    @ContributesAndroidInjector
    fun onboardingPage(): OnboardingPageFragment
}

@Module
interface ActivityScopedModule {

    @Binds
    fun navigator(navigatorImpl: NavigatorImpl): Navigator

    @Binds
    fun announcer(announcerImpl: AnnouncerImpl): Announcer

    @Binds
    fun resourceProvider(resourceProviderImpl: ResourceProviderImpl): ResourceProvider
}
