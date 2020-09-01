package com.octopus.electricjuice.common.resources

interface ResourceProvider {

    fun getString(juicyString: JuicyString): String
}