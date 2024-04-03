package com.example.android_architecture_patterns.mvi.repository

import com.example.android_architecture_patterns.mvi.model.Image

interface ImageRepository {
    suspend fun getRandomImage(): Image
}