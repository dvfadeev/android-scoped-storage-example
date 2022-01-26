package com.example.scoped_storage_example.core.ui.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.AnimationConstants
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SlideAnimationScreen(
    firstScreen: @Composable (() -> Unit),
    secondScreen: @Composable (() -> Unit),
    isShowSecondScreen: Boolean
) {
    Box(Modifier.fillMaxSize()) {
        AnimatedVisibility(
            !isShowSecondScreen,
            modifier = Modifier.fillMaxSize(),
            enter = slideInHorizontally(
                initialOffsetX = { -it },
                animationSpec = tween(
                    durationMillis = AnimationConstants.DefaultDurationMillis,
                    easing = LinearEasing
                )
            ),
            exit = slideOutHorizontally(
                targetOffsetX = { -it },
                animationSpec = tween(
                    durationMillis = AnimationConstants.DefaultDurationMillis,
                    easing = LinearEasing
                )
            )
        ) {
            firstScreen.invoke()
        }

        AnimatedVisibility(
            isShowSecondScreen,
            modifier = Modifier.fillMaxSize(),
            enter = slideInHorizontally(
                initialOffsetX = { it },
                animationSpec = tween(
                    durationMillis = AnimationConstants.DefaultDurationMillis,
                    easing = LinearEasing
                )
            ),
            exit = slideOutHorizontally(
                targetOffsetX = { it },
                animationSpec = tween(
                    durationMillis = AnimationConstants.DefaultDurationMillis,
                    easing = LinearEasing
                )
            )
        ) {
            secondScreen.invoke()
        }
    }
}