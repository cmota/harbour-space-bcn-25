package com.cmota.unsplash.data.images

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class CurrentUserCollection(
    val cover_photo: @Contextual @RawValue Any?,
    val id: Int?,
    val last_collected_at: String?,
    val published_at: String?,
    val title: String?,
    val updated_at: String?,
    val user: @Contextual @RawValue Any?
) : Parcelable