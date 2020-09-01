package com.octopus.electricjuice.common.platform

import com.octopus.electricjuice.githubrepositories.entities.GithubRepo

interface Navigator {
    fun goToDetails(githubRepo: GithubRepo)
    fun goToUrl(url: String)
    fun goToMain()
}