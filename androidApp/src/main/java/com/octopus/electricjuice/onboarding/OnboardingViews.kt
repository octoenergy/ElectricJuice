package com.octopus.electricjuice.onboarding

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.ui.tooling.preview.Preview
import com.octopus.electricjuice.theme.ElectricJuiceTheme
import com.octopus.electricjuice.R

@Composable
fun OnboardingScreenContainer(
    onboardingViewModel: OnboardingViewModel
) {
    val state =
        onboardingViewModel.viewStateStream().collectAsState(onboardingViewModel.defaultViewState())
    OnboardingScreen(
        state = state.value,
        onSkipClicked = { onboardingViewModel.onAction(OnboardingViewModel.UiAction.SkipClicked) }
    )
}

@Composable
fun OnboardingScreen(
    state: OnboardingViewModel.ViewState,
    onSkipClicked: () -> Unit
) {
    ConstraintLayout(Modifier.fillMaxSize()) {
        val (pager, skip, dots, next, getStarted) = createRefs()
        PageBackground(background = R.drawable.background, modifier = Modifier.fillMaxSize())
        Pager(state.onboardingPage, state.currentPageNumber)
        SkipButton(onClick = onSkipClicked, modifier = Modifier.constrainAs(skip) {
            top.linkTo(parent.top)
            end.linkTo(parent.end)
        })
        PagerDots(modifier = Modifier.constrainAs(dots) {
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
        })
        GetStartedButton(onClick = onSkipClicked, modifier = Modifier.constrainAs(getStarted) {
            bottom.linkTo(parent.bottom)
            end.linkTo(parent.end)
        })
        NextButton(onClick = onSkipClicked, modifier = Modifier.constrainAs(next) {
            bottom.linkTo(parent.bottom)
            end.linkTo(parent.end)
        })
    }
}

@Composable
fun Pager(
    onboardingPages: List<OnboardingPage>,
    currentPage: Int
) {
//    AndroidView(viewBlock = {
//        val viewPager = ViewPager(it)
//        viewPager
//    }) {
//        it.currentItem = currentPage
//    }
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
fun OnboardingPage(
    onboardingPages: OnboardingPage
) {
    Column {
        Text(text = onboardingPages.title)
        Text(text = onboardingPages.description)
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
    Text(text = "Pager dots", modifier = modifier)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ElectricJuiceTheme {
        OnboardingScreen(
            state = aOnboardingViewState(),
            onSkipClicked = {}
        )
    }
}

private fun aOnboardingViewState(): OnboardingViewModel.ViewState {
    return OnboardingViewModel.ViewState()
}