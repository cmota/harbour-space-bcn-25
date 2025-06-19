package com.cmota.unsplash.api

import com.cmota.unsplash.data.UnsplashItem
import com.cmota.unsplash.data.cb.UnsplashResult
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import kotlin.getValue

private val BASE_URL = "https://api.unsplash.com/"

private val retrofit by lazy {
  val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

  Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()
    .create<UnsplashApi>()
}

class UnsplashProvider {

  fun fetchPhotos(cb : UnsplashResult) {
    retrofit.fetchPhotos().enqueue(object : Callback<List<UnsplashItem>> {
      override fun onResponse(
        call: Call<List<UnsplashItem>>,
        response: Response<List<UnsplashItem>>
      ) {
        val output = response.body()
        if (response.isSuccessful && output != null) {
          cb.onDataFetchedSuccess(output)
        } else {
          cb.onDataFetchedFailed("${response.code()}: ${response.errorBody()}")
        }
      }

      override fun onFailure(call: Call<List<UnsplashItem>>, t: Throwable) {
        cb.onDataFetchedFailed("Error: ${t.message}")
      }
    })
  }
}