package com.example.functionalityapp.core.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class User (
    val name: String,
    val roleName: String

): Parcelable



