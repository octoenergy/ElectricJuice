package com.octopus.electricjuice.onboarding

import com.octopus.electricjuice.R
import javax.inject.Inject

class OnboardingStringMapper @Inject constructor() {

    fun map(onboardingString: OnboardingString): Int {
        return when (onboardingString) {
            OnboardingString.OnboardingPageOneTitle -> R.string.onboarding_page_one_title
            OnboardingString.OnboardingPageOneDescription -> R.string.onboarding_page_one_description
            OnboardingString.OnboardingPageTwoTitle -> R.string.onboarding_page_two_title
            OnboardingString.OnboardingPageTwoDescription -> R.string.onboarding_page_two_description
            OnboardingString.OnboardingPageThreeTitle -> R.string.onboarding_page_three_title
            OnboardingString.OnboardingPageThreeDescription -> R.string.onboarding_page_three_description
        }
    }
}