package com.octopus.electricjuice.onboarding

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.ui.tooling.preview.Preview
import com.octopus.electricjuice.theme.ElectricJuiceTheme

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
    ConstraintLayout {
        val (pager, skip, dots, next, getStarted) = createRefs()
        Pager(state.onboardingPage, state.currentPageNumber)
        SkipButton(onClick = onSkipClicked, modifier = Modifier.constrainAs(skip) {
            top.linkTo(parent.top)
            end.linkTo(parent.end)
        })
//        PagerDots()
//        NextButton()
//        GetStartedButton()
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
fun NextButton() {
    Text(text = "Next")
}

@Composable
fun GetStartedButton() {
    Text(text = "Get started")
}

@Composable
fun PagerDots() {
    Text(text = "Pager dots")
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    ElectricJuiceTheme {
//        OnboardingScreen({})
//    }
//}