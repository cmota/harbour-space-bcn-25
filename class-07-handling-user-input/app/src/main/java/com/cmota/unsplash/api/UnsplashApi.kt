package com.cmota.unsplash.api

import com.cmota.unsplash.data.SearchResult
import com.cmota.unsplash.data.UnsplashItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

private const val CLIENT_ID = "Client-ID"
private const val ACCESS_KEY = "kO6m_gqEjnmJCdrg7uCUHirlO-u9soB6TPJ66IYXhGk"

interface UnsplashApi {

  @Headers("Authorization: $CLIENT_ID $ACCESS_KEY")
  @GET("photos")
  fun fetchPhotos(): Call<List<UnsplashItem>>

  @Headers("Authorization: $CLIENT_ID $ACCESS_KEY")
  @GET("search/photos")
  fun searchPhotos(@Query("query") keyword: String): Call<SearchResult>
}