package com.octopus.electricjuice

import android.os.Bundle
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.setContent
import androidx.core.view.WindowCompat
import androidx.ui.tooling.preview.Preview
import com.octopus.electricjuice.common.ProvideDisplayInsets
import com.octopus.electricjuice.common.ui.MotherAppCompatActivity
import com.octopus.electricjuice.common.viewmodels.LifecycleReceiver
import com.octopus.electricjuice.githubrepositories.MainViewModel
import com.octopus.electricjuice.onboarding.OnboardingScreenContainer
import com.octopus.electricjuice.onboarding.OnboardingViewModel
import com.octopus.electricjuice.theme.ElectricJuiceTheme
import javax.inject.Inject

class ElectricJuiceActivity : MotherAppCompatActivity() {

    @Inject
    lateinit var onboardingViewModel: OnboardingViewModel

    override fun getLifecycleReceivers(): List<LifecycleReceiver> {
        return emptyList()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // This app draws behind the system bars, so we want to handle fitting system windows
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            MyApp {
                OnboardingScreenContainer(onboardingViewModel = onboardingViewModel)
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    ElectricJuiceTheme {
        Surface(color = MaterialTheme.colors.background) {
            ProvideDisplayInsets {
                content()
            }
        }
    }
}