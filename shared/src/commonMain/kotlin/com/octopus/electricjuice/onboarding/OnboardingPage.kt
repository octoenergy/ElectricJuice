package com.octopus.electricjuice.onboarding

import com.octopus.electricjuice.common.resources.JuicyImage

data class OnboardingPage(
    val image: JuicyImage,
    val title: String,
    val description: String
)