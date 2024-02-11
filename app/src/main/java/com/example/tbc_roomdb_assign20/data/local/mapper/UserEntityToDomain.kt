package com.example.tbc_roomdb_assign20.data.local.mapper

import com.example.tbc_roomdb_assign20.data.local.entity.UserEntity
import com.example.tbc_roomdb_assign20.domain.model.User

fun UserEntity.toDomain(): User {
    return User(
        firstName = firstName,
        lastName = lastName,
        email = email,
        age = age
    )
}