package com.octopus.electricjuice.githubrepositories.services.github

import com.octopus.electricjuice.common.MakeInjectable
import com.octopus.electricjuice.common.networking.GITHUB_BASE_URL
import com.octopus.electricjuice.common.networking.httpClientEngine
import com.octopus.electricjuice.common.networking.ktorSerializer
import com.octopus.electricjuice.githubrepositories.entities.GithubRepo
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*

class GithubService @MakeInjectable constructor(
    private val githubRepoMapper: GithubRepoMapper
) {

    private val client = HttpClient(httpClientEngine) {
        install(JsonFeature) {
            serializer = ktorSerializer
        }
    }

    suspend fun fetchCodeRepos(username: String): List<GithubRepo> {
        val content: List<GithubRepoEntity> = client.get("$GITHUB_BASE_URL/users/$username/repos")
        return githubRepoMapper.map(content)
    }
}