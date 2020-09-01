package com.octopus.electricjuice.common.threading

import com.octopus.electricjuice.common.MakeInjectable
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class DispatcherProvider @MakeInjectable constructor()  {

    val main: CoroutineDispatcher = Dispatchers.Main

    val background: CoroutineDispatcher = Dispatchers.Background

}

expect val Dispatchers.Background: CoroutineDispatcher