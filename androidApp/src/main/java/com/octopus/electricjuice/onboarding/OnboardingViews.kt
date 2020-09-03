package com.octopus.electricjuice.onboarding

import android.widget.HorizontalScrollView
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.Stack
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.viewinterop.AndroidView
import androidx.ui.tooling.preview.Preview
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.octopus.electricjuice.ElectricJuiceActivity
import com.octopus.electricjuice.R
import com.octopus.electricjuice.common.navigationBarsPadding
import com.octopus.electricjuice.common.statusBarsPadding
import com.octopus.electricjuice.common.systemBarsPadding
import com.octopus.electricjuice.theme.ElectricJuiceTheme
import com.rd.PageIndicatorView

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
        PageBackground(background = R.drawable.onboarding_background, modifier = Modifier.fillMaxSize())
        Pager(state.onboardingPages, state.currentPageNumber, Modifier.fillMaxSize())
        ConstraintLayout(
            Modifier.fillMaxSize()
                .systemBarsPadding()
        ) {
            val (skip, dots, next, getStarted) = createRefs()
            SkipButton(onClick = onSkipClicked, modifier = Modifier.constrainAs(skip) {
                top.linkTo(parent.top)
                end.linkTo(parent.end)
            })
            PagerDots(modifier = Modifier.constrainAs(dots) {
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
            })
            GetStartedButton(
                onClick = onGetStartedClicked,
                modifier = Modifier.constrainAs(getStarted) {
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                })
            NextButton(onClick = onNextClicked, modifier = Modifier.constrainAs(next) {
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end)
            })
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
//        viewPager.id = R.id.viewPager
        viewPager.adapter = OnboardingPagerAdapter(onboardingPages, it as AppCompatActivity)
        viewPager.setPageTransformer(ZoomOutPageTransformer())
        viewPager
    }) {
        it.currentItem = currentPage
    }
}

@Composable
fun SkipButton(
    onClick: () -> Unit,
    modifier: Modifier
) {
    Button(onClick = onClick, modifier = modifier) {
        Text("Skip")
    }
}

@Composable
fun NextButton(
    onClick: () -> Unit,
    modifier: Modifier
) {
    Button(onClick = onClick, modifier = modifier) {
        Text("Next")
    }
}

@Composable
fun GetStartedButton(
    onClick: () -> Unit,
    modifier: Modifier
) {
    Button(onClick = onClick, modifier = modifier) {
        Text("Get started")
    }
}

@Composable
fun PagerDots(modifier: Modifier) {
    AndroidView(viewBlock = {
        val pageIndicators = PageIndicatorView(it)
        pageIndicators.radius = 6
        pageIndicators.padding = 6
        pageIndicators.selectedColor = it.getColor(R.color.colorAccent)
        pageIndicators.unselectedColor = it.getColor(R.color.colorPrimary)
        pageIndicators
    }) {
//        it.currentItem = currentPage
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