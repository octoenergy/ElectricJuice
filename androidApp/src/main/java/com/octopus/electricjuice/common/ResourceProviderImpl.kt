package com.octopus.electricjuice.common

import android.app.Application
import com.octopus.electricjuice.common.resources.JuicyString
import com.octopus.electricjuice.common.resources.ResourceProvider
import com.octopus.electricjuice.onboarding.OnboardingString
import com.octopus.electricjuice.onboarding.OnboardingStringMapper
import java.lang.RuntimeException
import javax.inject.Inject

class ResourceProviderImpl @Inject constructor(
    private val application: Application,
    private val onboardingStringMapper: OnboardingStringMapper,
) : ResourceProvider {

    override fun getString(juicyString: JuicyString): String {
        val id = when (juicyString) {
            is OnboardingString -> onboardingStringMapper.map(juicyString)
            else -> throw RuntimeException("String isn't handled = $juicyString")
        }
        return application.getString(id)
    }
}