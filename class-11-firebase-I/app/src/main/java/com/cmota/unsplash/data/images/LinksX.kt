package com.cmota.unsplash.data.images

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class LinksX(
    val html: String?,
    val likes: String?,
    val photos: String?,
    val portfolio: String?,
    val self: String?
) : Parcelable