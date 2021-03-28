package com.contactica.pingpong.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Radio(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "radio_name") val radioName: String?,
    @ColumnInfo(name = "radio_url") val radioURL: String?
)
