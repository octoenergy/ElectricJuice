package com.octopus.electricjuice.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.HorizontalScrollView
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Box
import androidx.compose.foundation.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.RowScope.gravity
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.ui.tooling.preview.Preview
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.octopus.electricjuice.ElectricJuiceActivity
import com.octopus.electricjuice.ElectricJuiceApp
import com.octopus.electricjuice.R
import com.octopus.electricjuice.common.*
import com.octopus.electricjuice.common.ui.MotherFragment
import com.octopus.electricjuice.common.viewmodels.LifecycleReceiver
import com.octopus.electricjuice.theme.*
import com.rd.PageIndicatorView
import javax.inject.Inject

class OnboardingFragment : MotherFragment() {

    @Inject
    lateinit var onboardingViewModel: OnboardingViewModel

    companion object {
        fun instance(): OnboardingFragment {
            return OnboardingFragment()
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
                ElectricJuiceApp {
                    OnboardingScreenContainer(onboardingViewModel = onboardingViewModel)
                }
            }
        }
    }
}

@Composable
fun OnboardingScreenContainer(
    onboardingViewModel: OnboardingViewModel
) {
    val state =
        onboardingViewModel.viewStateStream().collectAsState(onboardingViewModel.defaultViewState())
    OnboardingScreen(
        state = state.value,
        onSkipClicked = { onboardingViewModel.onAction(OnboardingViewModel.UiAction.SkipClicked) },
        onNextClicked = { onboardingViewModel.onAction(OnboardingViewModel.UiAction.NextClicked) },
        onGetStartedClicked = { onboardingViewModel.onAction(OnboardingViewModel.UiAction.GetStartedClicked) }
    )
}

@Composable
fun OnboardingScreen(
    state: OnboardingViewModel.ViewState,
    onSkipClicked: () -> Unit,
    onNextClicked: () -> Unit,
    onGetStartedClicked: () -> Unit,
) {
    Stack {
        PageBackground(
            background = R.drawable.onboarding_background,
            modifier = Modifier.fillMaxSize()
        )
        Pager(state.onboardingPages, state.currentPageNumber, Modifier.fillMaxSize())
        ConstraintLayout(Modifier.fillMaxSize().systemBarsPadding()) {
            val (skip, next, getStarted) = createRefs()
            if (state.isSkipButtonVisible) {
                TextButton(
                    onClick = onSkipClicked,
                    modifier = Modifier.padding(margin).constrainAs(skip) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }) {
                    Text(
                        stringResource(id = R.string.common_word_skip),
                        color = Color.White,
                        style = MaterialTheme.typography.button
                    )
                }
            }
            if (state.isGetStartedButtonVisible) {
                LayeredButton(
                    string = stringResource(id = R.string.onboarding_final_page_button),
                    onClick = onGetStartedClicked,
                    modifier = Modifier.padding(margin).constrainAs(getStarted) {
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end)
                    },
                )
            } else {
                LayeredFab(
                    modifier = Modifier.padding(margin).constrainAs(next) {
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end)
                    },
                    onClick = onNextClicked
                )
            }
        }
    }
}

@Composable
fun PageBackground(
    @DrawableRes background: Int,
    modifier: Modifier
) {
    Image(
        asset = imageResource(id = background),
        contentScale = ContentScale.Fit,
        modifier = modifier
    )
}

@Composable
fun Pager(
    onboardingPages: List<OnboardingPage>,
    currentPage: Int,
    modifier: Modifier
) {
    AndroidView(viewBlock = {
        val viewPager = ViewPager2(it)
        viewPager.adapter = OnboardingPagerAdapter(onboardingPages, (it as AppCompatActivity))

        val layout = FrameLayout(it)
        layout.addView(viewPager)
        layout
    }) {
        val viewPager: ViewPager2 = it.getChildAt(0) as ViewPager2
        viewPager.currentItem = currentPage
    }
}

@Preview
@Composable
fun OnboardingScreenPreview() {
    ElectricJuiceTheme {
        OnboardingScreen(
            state = aOnboardingViewState(),
            onSkipClicked = {},
            onNextClicked = {},
            onGetStartedClicked = {},
        )
    }
}

private fun aOnboardingViewState(): OnboardingViewModel.ViewState {
    return OnboardingViewModel.ViewState()
}