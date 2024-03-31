package com.example.android_architecture_patterns.mvp.repository

import com.example.android_architecture_patterns.ImageResponse
import com.example.android_architecture_patterns.RetrofitManager
import retrofit2.Call
import retrofit2.Response

class ImageRepositoryImpl : ImageRepository {
    override fun getRandomImage(callBack: ImageRepository.CallBack) {
        RetrofitManager.imageService.getRandomImage()
            .enqueue(object : retrofit2.Callback<ImageResponse>{
                override fun onResponse(
                    call: Call<ImageResponse>,
                    response: Response<ImageResponse>
                ) {
                    if(response.isSuccessful){
                        response.body()?.let {
                            callBack.loadImage(it.urls.regular, it.color)
                        }
                    }
                }

                override fun onFailure(call: Call<ImageResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
    }
}