package com.octopus.electricjuice.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalDrawerLayout
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.style.TextAlign
import androidx.ui.tooling.preview.Preview
import com.octopus.electricjuice.common.PREVIEW_MEDIUM_TEXT
import com.octopus.electricjuice.common.PREVIEW_SHORT_TEXT
import com.octopus.electricjuice.common.map
import com.octopus.electricjuice.common.ui.MotherFragment
import com.octopus.electricjuice.common.viewmodels.LifecycleReceiver
import com.octopus.electricjuice.theme.ElectricJuiceTheme
import com.octopus.electricjuice.theme.grid16
import com.octopus.electricjuice.theme.grid32
import com.octopus.electricjuice.theme.grid48

class OnboardingPageFragment : MotherFragment() {

    companion object {
        fun instance(): OnboardingPageFragment {
            return OnboardingPageFragment()
        }
    }

    /**
     * Yes this is rather hacky
     * Java serializable/parcelize isn't a concept in KMP
     * so can't add objects to bundle without pre-mapping to android world
     *
     * In this case it wouldn't be an issue, so lets skip.
     * Additionally, this fragment is a stop gap until Jetpack Compose supports ViewPagers
     * no use writing a complex solution that may well not be needed soon
     */
    var onboardingPage: OnboardingPage? = null

    override fun getLifecycleReceivers(): List<LifecycleReceiver> {
        return emptyList()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                OnboardingPage(onboardingPage = onboardingPage!!)
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
        Spacer(modifier = Modifier.weight(0.3f))
        Image(
            asset = imageResource(id = onboardingPage.image.map()),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(grid48))
        Text(
            text = onboardingPage.title,
            style = MaterialTheme.typography.subtitle1,
            color = MaterialTheme.colors.onPrimary,
        )
        Spacer(modifier = Modifier.height(grid16))
        Text(
            text = onboardingPage.description,
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.onPrimary,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.weight(0.7f))
    }
}

@Preview
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
        OnboardingImage.OnboardingPageOne, PREVIEW_SHORT_TEXT, PREVIEW_MEDIUM_TEXT
    )
}