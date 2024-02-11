package com.example.tbc_roomdb_assign20.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users_info")
data class UserEntity(
    @ColumnInfo(name = "first_name")
    val firstName: String,
    @ColumnInfo(name = "last_name")
    val lastName: String,
    val age: Int,
    @PrimaryKey
    val email: String
)
