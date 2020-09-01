package com.octopus.electricjuice.common.platform

import android.widget.Toast
import com.octopus.electricjuice.ElectricJuiceActivity
import com.octopus.electricjuice.common.SingleActivity
import javax.inject.Inject

@SingleActivity
class AnnouncerImpl@Inject constructor(
        private val electricJuiceActivity: ElectricJuiceActivity
): Announcer {

    override fun announce(text: String) {
        Toast.makeText(electricJuiceActivity, text, Toast.LENGTH_LONG).show()
    }
}