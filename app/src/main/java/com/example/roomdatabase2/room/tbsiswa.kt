package com.example.roomdatabase2.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class tbsiswa (
    @PrimaryKey
    val nis:Int,
    val nama:String,
    val kelas:String,
    val alamat:String
)
