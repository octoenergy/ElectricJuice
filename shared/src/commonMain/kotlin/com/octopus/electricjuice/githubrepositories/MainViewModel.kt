package com.octopus.electricjuice.githubrepositories

import com.octopus.electricjuice.common.MakeInjectable
import com.octopus.electricjuice.common.SingleActivity
import com.octopus.electricjuice.common.platform.Announcer
import com.octopus.electricjuice.common.platform.Logger
import com.octopus.electricjuice.common.platform.Navigator
import com.octopus.electricjuice.common.threading.DispatcherProvider
import com.octopus.electricjuice.common.viewmodels.MotherViewModel
import com.octopus.electricjuice.githubrepositories.entities.GithubRepo

@SingleActivity
class MainViewModel @MakeInjectable constructor(
    private val githubRepoManager: GithubRepoManager,
    private val navigator: Navigator,
    private val announcer: Announcer,
    private val dispatcherProvider: DispatcherProvider,
    private val logger: Logger,
) : MotherViewModel<MainViewModel.ViewState, MainViewModel.UiAction>(
    dispatcherProvider
) {

    private val TEST_USER: String = "JakeWharton"

    override fun onAction(action: UiAction) {
        when (action) {
            is UiAction.RepositoryClicked -> navigator.goToDetails(action.githubRepo)
            is UiAction.LoadReposClicked -> loadResults()
        }
    }

    private fun loadResults() {
        logger.log("Load results")
        emit(lastViewState.copy(loadingIsVisible = true))
//        coroutineScope.launch {
//            try {
//                val result = withContext(dispatcherProvider.main) {
//                    githubRepoManager.fetchSortedRepos(TEST_USER)
//                }
//                emit(lastViewState.copy(loadingIsVisible = false, results = result))
//            } catch (e: Exception) {
//                logger.log("Exception = $e")
//                emit(lastViewState.copy(loadingIsVisible = false))
//                announcer.announce(e.toString())
//            }
//        }
    }

    override fun defaultViewState(): ViewState {
        return ViewState()
    }

    data class ViewState(
        val loadingIsVisible: Boolean = false,
        val results: List<GithubRepo> = listOf()
    ) : MotherViewModel.ViewState

    sealed class UiAction : MotherViewModel.UiAction {
        data class RepositoryClicked(val githubRepo: GithubRepo) : UiAction()
        object LoadReposClicked : UiAction()
    }
}