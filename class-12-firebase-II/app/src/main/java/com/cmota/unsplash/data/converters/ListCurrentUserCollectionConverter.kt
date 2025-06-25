package com.cmota.unsplash.data.converters

import androidx.room.TypeConverter
import com.cmota.unsplash.data.images.CurrentUserCollection
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ListCurrentUserCollectionConverter {

  @TypeConverter
  fun fromListCurrentUserCollectionConverter(list: List<CurrentUserCollection>?): String {
    return Json.encodeToString(list)
  }

  @TypeConverter
  fun toListCurrentUserCollectionConverter(value: String): List<CurrentUserCollection>? {
    return Json.decodeFromString(value)
  }
}