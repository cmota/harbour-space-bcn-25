package com.cmota.unsplash.data.converters

import androidx.room.TypeConverter
import com.cmota.unsplash.data.images.LinksX
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class LinksXConverter {

  @TypeConverter
  fun fromUrls(links: LinksX): String {
    return Json.encodeToString(links)
  }

  @TypeConverter
  fun toUrls(value: String): LinksX {
    return Json.decodeFromString(value)
  }
}