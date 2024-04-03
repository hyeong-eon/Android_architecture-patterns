package com.example.android_architecture_patterns.mvi

sealed class MviIntent  {
    object LoadImage : MviIntent()
}