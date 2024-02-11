package com.example.tbc_roomdb_assign20.presentation.mapper

import com.example.tbc_roomdb_assign20.domain.model.User
import com.example.tbc_roomdb_assign20.presentation.model.UserPresentation

fun UserPresentation.toDomain(): User {
    return User(
        firstName = firstName,
        lastName = lastName,
        email = email,
        age = age
    )
}