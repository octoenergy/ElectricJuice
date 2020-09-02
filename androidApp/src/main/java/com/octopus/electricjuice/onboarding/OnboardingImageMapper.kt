package com.octopus.electricjuice.onboarding

import com.octopus.electricjuice.R

/**
 * @return @DrawableRes
 */
fun OnboardingImage.mapOnboardingImage(): Int {
    return when (this) {
        OnboardingImage.OnboardingPageOne -> R.drawable.onboarding_page_one
        OnboardingImage.OnboardingPageTwo -> R.drawable.onboarding_page_one
        OnboardingImage.OnboardingPageThree -> R.drawable.onboarding_page_one
    }
}