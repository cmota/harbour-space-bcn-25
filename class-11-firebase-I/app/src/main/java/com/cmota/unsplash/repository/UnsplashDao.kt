package com.cmota.unsplash.repository

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cmota.unsplash.data.images.UnsplashItem

@Dao
interface UnsplashDao {

  @Query("SELECT * FROM UnsplashItem")
  fun getAllImages(): LiveData<List<UnsplashItem>>

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  fun insertImage(image: UnsplashItem)
}