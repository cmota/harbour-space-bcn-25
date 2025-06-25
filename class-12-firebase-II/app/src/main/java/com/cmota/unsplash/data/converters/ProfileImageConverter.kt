package com.cmota.unsplash.data.converters

import androidx.room.TypeConverter
import com.cmota.unsplash.data.images.ProfileImage
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ProfileImageConverter {

  @TypeConverter
  fun fromUrls(profile: ProfileImage): String {
    return Json.encodeToString(profile)
  }

  @TypeConverter
  fun toUrls(value: String): ProfileImage {
    return Json.decodeFromString(value)
  }
}