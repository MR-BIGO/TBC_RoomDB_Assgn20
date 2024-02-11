package com.example.tbc_roomdb_assign20.domain.repository

import com.example.tbc_roomdb_assign20.domain.model.User

interface IUserRepository {
    suspend fun getUsersNumber(): Int
    suspend fun getUserByEmail(email: String): User
    suspend fun deleteUser(user: User)
    suspend fun insertUser(user: User)
    suspend fun updateUser(user: User)
}