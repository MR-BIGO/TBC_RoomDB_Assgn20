package com.example.tbc_roomdb_assign20.presentation.mapper

import com.example.tbc_roomdb_assign20.domain.model.User
import com.example.tbc_roomdb_assign20.presentation.model.UserPresentation

fun User.toPresentation(): UserPresentation{
    return UserPresentation(
        firstName = firstName,
        lastName = lastName,
        email = email,
        age = age
    )
}