package com.octopus.electricjuice.onboarding

import com.octopus.electricjuice.common.*
import com.octopus.electricjuice.common.platform.Navigator
import com.octopus.electricjuice.common.resources.JuicyImage
import com.octopus.electricjuice.common.resources.JuicyString
import com.octopus.electricjuice.common.resources.ResourceProvider
import com.octopus.electricjuice.common.threading.DispatcherProvider
import com.octopus.electricjuice.common.viewmodels.MotherViewModel

@SingleActivity
class OnboardingViewModel @MakeInjectable constructor(
    private val navigator: Navigator,
    private val dispatcherProvider: DispatcherProvider,
    private val resourceProvider: ResourceProvider,
) : MotherViewModel<OnboardingViewModel.ViewState, OnboardingViewModel.UiAction>(
    dispatcherProvider
) {

    override fun onAction(action: UiAction) {
        when (action) {
            UiAction.SkipClicked -> navigator.goToMap()
            UiAction.GetStartedClicked -> navigator.goToMap()
            UiAction.NextClicked -> selectNextPage()
            UiAction.PageScrolled -> selectNextPage()
        }
    }

    private fun selectNextPage() {
        val nextPageNumber = lastViewState.currentPageNumber
        val numberOfPages = lastViewState.onboardingPages.size
        emit(
            lastViewState.copy(
                currentPageNumber = nextPageNumber,
                isGetStartedButtonVisible = nextPageNumber == numberOfPages - 1,
                isSkipButtonVisible = nextPageNumber != numberOfPages - 1,
            )
        )
    }

    override fun defaultViewState(): ViewState {
        return ViewState(
            onboardingPages = listOf(
                OnboardingPage(
                    OnboardingImage.OnboardingPageOne,
                    resourceProvider.getString(OnboardingString.OnboardingPageOneTitle),
                    resourceProvider.getString(OnboardingString.OnboardingPageOneDescription)
                ),
                OnboardingPage(
                    OnboardingImage.OnboardingPageTwo,
                    resourceProvider.getString(OnboardingString.OnboardingPageTwoTitle),
                    resourceProvider.getString(OnboardingString.OnboardingPageTwoDescription)
                ),
                OnboardingPage(
                    OnboardingImage.OnboardingPageThree,
                    resourceProvider.getString(OnboardingString.OnboardingPageThreeTitle),
                    resourceProvider.getString(OnboardingString.OnboardingPageThreeDescription)
                )
            )
        )
    }

    data class ViewState(
        val isGetStartedButtonVisible: Boolean = false,
        val isSkipButtonVisible: Boolean = true,
        val currentPageNumber: Int = 0,
        val onboardingPages: List<OnboardingPage> = listOf()
    ) : MotherViewModel.ViewState

    sealed class UiAction : MotherViewModel.UiAction {
        object SkipClicked : UiAction()
        object GetStartedClicked : UiAction()
        object NextClicked : UiAction()
        object PageScrolled : UiAction()
    }
}