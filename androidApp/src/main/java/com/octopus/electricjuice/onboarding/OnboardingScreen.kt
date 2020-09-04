package com.octopus.electricjuice.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
import com.octopus.electricjuice.common.navigationBarsPadding
import com.octopus.electricjuice.common.statusBarsPadding
import com.octopus.electricjuice.common.systemBarsPadding
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
            val (skip, dots, next, getStarted) = createRefs()
            if (state.isSkipButtonVisible) {
                TextButton(onClick = onSkipClicked, modifier = Modifier.constrainAs(skip) {
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
            PagerDots(modifier = Modifier.constrainAs(dots) {
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
            })
            if (state.isGetStartedButtonVisible) {
                Button(
                    onClick = onGetStartedClicked,
                    modifier = Modifier.constrainAs(getStarted) {
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end)
                    }) {
                    Text(
                        stringResource(id = R.string.onboarding_final_page_button),
                        style = MaterialTheme.typography.button
                    )
                }
            } else {
//                LayeredBackground(
//                    shape = CircleShape,
//                    modifier = Modifier.constrainAs(next) {
//                        bottom.linkTo(parent.bottom)
//                        end.linkTo(parent.end)
//                    })
                FloatingActionButton(
                    backgroundColor = MaterialTheme.colors.primary,
                    onClick = onNextClicked,
                    modifier = Modifier.constrainAs(next) {
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end)
                    }) {
                    Icon(
                        asset = vectorResource(id = R.drawable.ic_arrow_right),
                        tint = MaterialTheme.colors.onPrimary,
                    )
                }
            }
        }
    }
}

@Composable
fun LayeredBackground(
    shape: Shape,
    modifier: Modifier,
) {
    Stack(modifier = modifier.width(96.dp)) {
        Box(
            shape = shape,
            modifier = Modifier.size(grid48).padding(end = grid48).gravity(Alignment.CenterEnd),
            backgroundColor = Color.Black.copy(alpha = 0.2f),
        )
        Box(
            shape = shape,
            modifier = Modifier.size(grid48).padding(end = grid32).gravity(Alignment.CenterEnd),
            backgroundColor = Color.Black.copy(alpha = 0.4f),
        )
        Box(
            shape = shape,
            modifier = Modifier.size(grid48).padding(end = grid16).gravity(Alignment.CenterEnd),
            backgroundColor = Color.Black.copy(alpha = 0.6f),
        )
        Box(
            shape = shape,
            modifier = Modifier.size(grid48).gravity(Alignment.CenterEnd),
            backgroundColor = Color.Black.copy(alpha = 1f),
        )
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