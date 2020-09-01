package com.octopus.electricjuice.common.platform

import android.content.Intent
import android.net.Uri
import androidx.navigation.findNavController
import com.octopus.electricjuice.R
import com.octopus.electricjuice.githubrepositories.entities.GithubRepo
import com.octopus.electricjuice.extensions.startActivity
import com.octopus.electricjuice.ElectricJuiceActivity
import com.octopus.electricjuice.common.SingleActivity
import com.octopus.electricjuice.githubrepositories.CurrentRepoRepository
import com.octopus.electricjuice.githubrepositories.DetailsFragmentDirections
import com.octopus.electricjuice.githubrepositories.MainFragmentDirections
import javax.inject.Inject

@SingleActivity
class NavigatorImpl @Inject constructor(
    private val electricJuiceActivity: ElectricJuiceActivity,
    private val currentRepoRepository: CurrentRepoRepository
): Navigator {

    override fun goToDetails(githubRepo: GithubRepo) {
        currentRepoRepository.githubRepo = githubRepo
        val action = MainFragmentDirections.actionMainFragmentToDetailsFragment()
        electricJuiceActivity.findNavController(R.id.nav_host_fragment).navigate(action)
    }

    override fun goToMain() {
        val action = DetailsFragmentDirections.actionDetailsFragmentToMainFragment()
        electricJuiceActivity.findNavController(R.id.nav_host_fragment).navigate(action)
    }

    override fun goToUrl(url: String) {
        Intent(Intent.ACTION_VIEW, Uri.parse(url)).startActivity(electricJuiceActivity)
    }
}