package com.octopus.electricjuice.onboarding

import com.octopus.electricjuice.common.resources.JuicyString

sealed class OnboardingString : JuicyString {
    object OnboardingPageOneTitle : OnboardingString()
    object OnboardingPageOneSubtitle : OnboardingString()
    object OnboardingPageTwoTitle : OnboardingString()
    object OnboardingPageTwoSubtitle : OnboardingString()
    object OnboardingPageThreeTitle : OnboardingString()
    object OnboardingPageThreeSubtitle : OnboardingString()
}