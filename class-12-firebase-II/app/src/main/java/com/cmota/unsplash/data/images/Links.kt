package com.cmota.unsplash.data.images

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Links(
    val download: String?,
    val download_location: String?,
    val html: String?,
    val self: String?
) : Parcelable