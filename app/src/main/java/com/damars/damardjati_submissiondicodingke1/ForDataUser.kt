package com.damars.damardjati_submissiondicodingke1

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ForDataUser (
        var this_name: String? = null,
        var this_username: String? = null,
        var this_location: String? = null,
        var this_follower: String? = null,
        var this_following: String? = null,
        var avatar: Int? = null,
        var this_company: String? = null,
        var this_repository: String? = null
): Parcelable