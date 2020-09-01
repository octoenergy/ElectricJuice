package com.octopus.electricjuice.onboarding

import com.octopus.electricjuice.common.*
import com.octopus.electricjuice.common.platform.Navigator
import com.octopus.electricjuice.common.threading.DispatcherProvider
import com.octopus.electricjuice.common.viewmodels.MotherViewModel

@SingleActivity
class OnboardingViewModel @MakeInjectable constructor(
    private val dispatcherProvider: DispatcherProvider,
) : MotherViewModel<OnboardingViewModel.ViewState, OnboardingViewModel.UiAction>(
    dispatcherProvider
) {

    override fun onAction(action: UiAction) {
        when (action) {
            UiAction.SkipClicked -> TODO()
            UiAction.NextClicked -> TODO()
            UiAction.PageScrolled -> TODO()
        }
    }

    override fun defaultViewState(): ViewState {
        return ViewState()
    }

    data class ViewState(
            val isGetStartedButtonVisible: Boolean = false,
            val isSkipButtonVisible: Boolean = true,
            val currentPageNumber: Int = 0,
            val onboardingPage: List<OnboardingPage> = listOf()
    ) : MotherViewModel.ViewState

    sealed class UiAction : MotherViewModel.UiAction {
        object SkipClicked : UiAction()
        object NextClicked : UiAction()
        object PageScrolled : UiAction()
    }
}