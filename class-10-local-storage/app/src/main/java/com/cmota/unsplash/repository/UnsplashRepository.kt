package com.cmota.unsplash.repository

import com.cmota.unsplash.data.images.UnsplashItem

class UnsplashRepository(val unsplashDao: UnsplashDao) {

  val allImages = unsplashDao.getAllImages()

  fun insertImage (image: UnsplashItem) {
    AppDatabase.databaseExecutors.execute {
      unsplashDao.insertImage(image)
    }
  }
}