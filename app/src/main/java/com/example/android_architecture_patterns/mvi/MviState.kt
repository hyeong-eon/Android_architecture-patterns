package com.example.android_architecture_patterns.mvi

import com.example.android_architecture_patterns.mvi.model.Image

sealed class MviState {
    object Idle: MviState()
    object Loading : MviState()
    data class LoadedImage(val image: Image, val count:Int):MviState()
}