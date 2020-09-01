package com.octopus.electricjuice.common.resources

sealed class JuicyImage {
    object OnboardingPageOne : JuicyImage()
    object OnboardingPageTwo : JuicyImage()
    object OnboardingPageThree : JuicyImage()
}