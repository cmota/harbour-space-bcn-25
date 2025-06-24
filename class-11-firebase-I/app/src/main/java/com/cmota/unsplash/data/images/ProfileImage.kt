package com.cmota.unsplash.data.images

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class ProfileImage(
    val large: String?,
    val medium: String?,
    val small: String?
) : Parcelable