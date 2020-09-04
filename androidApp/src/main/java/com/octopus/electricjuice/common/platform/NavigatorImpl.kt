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
import javax.inject.Inject

@SingleActivity
class NavigatorImpl @Inject constructor(
    private val electricJuiceActivity: ElectricJuiceActivity
): Navigator {

    override fun goToMap() {
        electricJuiceActivity.findNavController(R.id.nav_host_fragment).navigate(R.id.mapFragment)
    }

    override fun goToOnboarding() {
        electricJuiceActivity.findNavController(R.id.nav_host_fragment).navigate(R.id.onboardingFragment)
    }
}