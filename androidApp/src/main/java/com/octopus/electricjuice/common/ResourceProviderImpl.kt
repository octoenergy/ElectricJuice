package com.octopus.electricjuice.common

import com.octopus.electricjuice.common.resources.JuicyString
import com.octopus.electricjuice.common.resources.ResourceProvider
import javax.inject.Inject

class ResourceProviderImpl @Inject constructor() : ResourceProvider {
    override fun getString(juicyString: JuicyString): String {
        return "A string"
    }
}