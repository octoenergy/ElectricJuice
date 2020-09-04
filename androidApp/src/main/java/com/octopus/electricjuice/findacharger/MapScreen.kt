package com.octopus.electricjuice.findacharger

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
import com.octopus.electricjuice.common.platform.Navigator
import com.octopus.electricjuice.common.statusBarsPadding
import com.octopus.electricjuice.common.systemBarsPadding
import com.octopus.electricjuice.common.ui.MotherFragment
import com.octopus.electricjuice.common.viewmodels.LifecycleReceiver
import com.octopus.electricjuice.theme.*
import com.rd.PageIndicatorView
import javax.inject.Inject

class MapFragment : MotherFragment() {

    @Inject lateinit var navigator: Navigator

    companion object {
        fun instance(): MapFragment {
            return MapFragment()
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
                    MapScreen { navigator.goToOnboarding() }
                }
            }
        }
    }
}

@Composable
fun MapScreen(onClick: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "The map will be here!")
        Button(onClick = onClick) {
            Text(text = "ONBOARD AGAIN")
        }
    }
}