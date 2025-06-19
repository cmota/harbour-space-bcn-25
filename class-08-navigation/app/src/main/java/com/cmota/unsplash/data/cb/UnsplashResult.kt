package com.cmota.unsplash.data.cb

import com.cmota.unsplash.data.UnsplashItem

interface UnsplashResult {

  fun onDataFetchedSuccess(images : List<UnsplashItem>)

  fun onDataFetchedFailed(message: String)
}