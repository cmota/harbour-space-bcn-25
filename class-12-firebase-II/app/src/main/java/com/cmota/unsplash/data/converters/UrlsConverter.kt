package com.cmota.unsplash.data.converters

import androidx.room.TypeConverter
import com.cmota.unsplash.data.images.Urls
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class UrlsConverter {

  @TypeConverter
  fun fromUrls(urls: Urls): String {
    return Json.encodeToString(urls)
  }

  @TypeConverter
  fun toUrls(value: String): Urls {
    return Json.decodeFromString(value)
  }
}