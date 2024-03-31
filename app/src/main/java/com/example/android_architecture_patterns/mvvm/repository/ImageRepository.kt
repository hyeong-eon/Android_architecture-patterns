package com.example.android_architecture_patterns.mvvm.repository

import com.example.android_architecture_patterns.mvvm.model.Image
import io.reactivex.Single

interface ImageRepository {
    fun getRandomImage() : Single<Image>

}