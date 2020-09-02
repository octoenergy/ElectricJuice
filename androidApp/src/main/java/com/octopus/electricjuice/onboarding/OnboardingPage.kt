package com.octopus.electricjuice.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.ui.tooling.preview.Preview
import com.octopus.electricjuice.common.ui.MotherFragment
import com.octopus.electricjuice.common.viewmodels.LifecycleReceiver
import com.octopus.electricjuice.theme.ElectricJuiceTheme

class OnboardingPageFragment : MotherFragment() {

    companion object {
        fun instance(): OnboardingPageFragment {
            return OnboardingPageFragment()
        }
    }

    override fun getLifecycleReceivers(): List<LifecycleReceiver> {
        return emptyList()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                OnboardingPage(onboardingPage = aOnboardingPage())
            }
        }
    }
}

@Composable
fun OnboardingPage(
    onboardingPage: OnboardingPage
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalGravity = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = onboardingPage.title)
        Text(text = onboardingPage.description)
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingPagePreview() {
    ElectricJuiceTheme {
        OnboardingPage(
            onboardingPage = aOnboardingPage()
        )
    }
}

private fun aOnboardingPage(): OnboardingPage {
    return OnboardingPage(
        OnboardingImage.OnboardingPageOne, "Title", "Description"
    )
}