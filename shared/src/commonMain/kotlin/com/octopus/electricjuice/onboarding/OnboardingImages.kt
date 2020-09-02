package com.octopus.electricjuice.onboarding

import com.octopus.electricjuice.common.resources.JuicyImage

sealed class OnboardingImage : JuicyImage {
    object OnboardingPageOne : OnboardingImage()
    object OnboardingPageTwo : OnboardingImage()
    object OnboardingPageThree : OnboardingImage()
}