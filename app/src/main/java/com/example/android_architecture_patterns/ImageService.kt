package com.example.android_architecture_patterns

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ImageService {
    @Headers("Authorization: Client-ID JAflhQ1Vlc8sCISAEL6QQQdXikDfPd5N1UvvUCeqb5o")
    @GET("/photos/random")
    fun getRandomImage(): Call<ImageResponse>

}