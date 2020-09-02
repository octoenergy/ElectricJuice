package com.octopus.electricjuice.onboarding

import com.octopus.electricjuice.common.resources.JuicyString

sealed class OnboardingString : JuicyString {
    object OnboardingPageOneTitle : OnboardingString()
    object OnboardingPageOneDescription : OnboardingString()
    object OnboardingPageTwoTitle : OnboardingString()
    object OnboardingPageTwoDescription : OnboardingString()
    object OnboardingPageThreeTitle : OnboardingString()
    object OnboardingPageThreeDescription : OnboardingString()
}