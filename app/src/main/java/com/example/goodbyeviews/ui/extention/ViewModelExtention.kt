package com.example.goodbyeviews.ui.extention

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

fun <T> Flow<T>.stateIn(
    initialValue: T,
    scope: CoroutineScope,
    started: SharingStarted = SharingStarted.WhileSubscribed(5000L)
): StateFlow<T> = stateIn(scope, started, initialValue)