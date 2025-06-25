package com.cmota.unsplash.data.converters

import androidx.room.TypeConverter
import com.cmota.unsplash.data.images.User
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class UserConverter {

  @TypeConverter
  fun fromUrls(user: User): String {
    return Json.encodeToString(user)
  }

  @TypeConverter
  fun toUrls(value: String): User {
    return Json.decodeFromString(value)
  }
}