package com.octopus.electricjuice.githubrepositories

import com.octopus.electricjuice.common.MakeInjectable
import com.octopus.electricjuice.common.SingleActivity
import com.octopus.electricjuice.githubrepositories.entities.GithubRepo

@SingleActivity
class CurrentRepoRepository @MakeInjectable constructor() {

    var githubRepo: GithubRepo? = null
}