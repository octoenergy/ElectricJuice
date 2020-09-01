package com.octopus.electricjuice.githubrepositories.services.github

import com.octopus.electricjuice.common.MakeInjectable
import com.octopus.electricjuice.githubrepositories.entities.GithubRepo

class GithubRepoMapper @MakeInjectable constructor() {

    fun map(gitApiEntities: List<GithubRepoEntity>): List<GithubRepo> {
        return gitApiEntities.map { it.map() }
    }

    fun GithubRepoEntity.map(): GithubRepo {
        return GithubRepo(
            id = this.id,
            name = this.name,
            url = this.url
        )
    }
}