package com.adhibuchori.wastewizard.utils

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class WasteInformation(
    val sortWaste: String,
    val recycleWaste: String
) : Parcelable