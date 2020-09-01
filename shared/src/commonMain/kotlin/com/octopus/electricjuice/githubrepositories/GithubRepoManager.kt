package com.octopus.electricjuice.githubrepositories

import com.octopus.electricjuice.githubrepositories.services.github.GithubService
import com.octopus.electricjuice.common.MakeInjectable
import com.octopus.electricjuice.githubrepositories.entities.GithubRepo

class GithubRepoManager @MakeInjectable constructor(
    private val githubService: GithubService
) {

    suspend fun fetchSortedRepos(userName: String): List<GithubRepo> {
        return githubService.fetchCodeRepos(userName)
            .sortedBy { it.name }
    }
}