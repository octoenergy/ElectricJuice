package com.octopus.electricjuice.common

import com.octopus.electricjuice.common.resources.JuicyImage
import com.octopus.electricjuice.onboarding.OnboardingImage
import com.octopus.electricjuice.onboarding.mapOnboardingImage
import java.lang.RuntimeException

fun JuicyImage.map(): Int {
    return when (this) {
        is OnboardingImage -> this.mapOnboardingImage()
        else -> throw RuntimeException("Image is not handled = $this")
    }
}