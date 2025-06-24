package com.cmota.unsplash

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cmota.unsplash.api.UnsplashProvider
import com.cmota.unsplash.data.cb.UnsplashResult
import com.cmota.unsplash.data.collections.UnsplashCollectionItem
import com.cmota.unsplash.data.images.UnsplashItem
import com.cmota.unsplash.repository.AppDatabase
import com.cmota.unsplash.repository.UnsplashRepository

class MainViewModel(application: Application) : AndroidViewModel(application), UnsplashResult {

  private val _images: MutableLiveData<List<UnsplashItem>> = MutableLiveData()
  val images: LiveData<List<UnsplashItem>> = _images

  private val _collections: MutableLiveData<List<UnsplashCollectionItem>> = MutableLiveData()
  val collections: LiveData<List<UnsplashCollectionItem>> = _collections

  private val _error: MutableLiveData<String> = MutableLiveData()
  val error: LiveData<String> = _error

  private val _loading: MutableLiveData<Boolean> = MutableLiveData()
  val loading: LiveData<Boolean> = _loading

  private val provider = UnsplashProvider()

  val database = AppDatabase.getDatabase(context = application)
  val repository = UnsplashRepository(database.unsplashDao())

  fun fetchPhotos() {
    _loading.value = true
    provider.fetchPhotos(this)
  }

  fun searchPhoto(keyword: String) {
    provider.searchPhotos(keyword, this)
  }

  fun fetchCollections() {
    provider.fetchCollections(this)
  }

  override fun onDataFetchedSuccess(images: List<UnsplashItem>) {
    _images.value = images
    _loading.value = false

    for (image in images) {
      repository.insertImage(image)
    }
  }

  override fun onDataCollectionFetchedSuccess(collections: List<UnsplashCollectionItem>) {
    _collections.value = collections
  }

  override fun onDataFetchedFailed(message: String) {
    _error.value = message
    _loading.value = false
  }
}