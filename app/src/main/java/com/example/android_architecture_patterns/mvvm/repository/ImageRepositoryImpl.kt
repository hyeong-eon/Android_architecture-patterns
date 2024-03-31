package com.example.android_architecture_patterns.mvvm.repository

import com.example.android_architecture_patterns.RetrofitManager
import com.example.android_architecture_patterns.mvvm.model.Image
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit

class ImageRepositoryImpl:ImageRepository {
    override fun getRandomImage() = RetrofitManager.imageService.getRandomImageRx()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .flatMap { item ->
            Single.just(Image(item.urls.regular, item.color))
        }
}