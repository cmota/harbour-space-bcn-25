package com.cmota.unsplash.data.converters

import androidx.room.TypeConverter
import com.cmota.unsplash.data.images.Links
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class LinksConverter {

  @TypeConverter
  fun fromUrls(links: Links): String {
    return Json.encodeToString(links)
  }

  @TypeConverter
  fun toUrls(value: String): Links {
    return Json.decodeFromString(value)
  }
}