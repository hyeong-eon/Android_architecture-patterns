package com.example.android_architecture_patterns.mvp.repository

import android.graphics.Color

interface ImageRepository {
    fun getRandomImage(callBack: CallBack)

    interface CallBack{
        fun loadImage(url : String, color: String)
    }
}