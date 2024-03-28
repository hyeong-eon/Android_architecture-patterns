package com.example.android_architecture_patterns.mvc.provider

import com.example.android_architecture_patterns.ImageResponse
import com.example.android_architecture_patterns.RetrofitManager
import retrofit2.Call
import retrofit2.Response

class ImageProvider(private val callback: Callback) {

    fun getRandomImage(){
        RetrofitManager.imageService.getRandomImage()
            .enqueue(object : retrofit2.Callback<ImageResponse>{
                override fun onResponse(
                    call: Call<ImageResponse>,
                    response: Response<ImageResponse>
                ) {
                    if(response.isSuccessful) {
                        response.body()?.let {
                            callback.loadImage(it.urls.regular, it.color)
                        }
                    }
                }

                override fun onFailure(call: Call<ImageResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
    }

    interface Callback{
        fun loadImage(url: String, color: String)
    }
}