package com.octopus.electricjuice.common

import javax.inject.Scope

actual typealias CallSuper = androidx.annotation.CallSuper

actual typealias MakeInjectable = javax.inject.Inject

@Scope
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
actual annotation class PerApplication

@Scope
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
actual annotation class SingleActivity