package com.cmota.unsplash.data.images

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Urls(
    val full: String?,
    val raw: String?,
    val regular: String?,
    val small: String?,
    val thumb: String?
) : Parcelable