package com.example.tbc_roomdb_assign20.data.repository.local

import com.example.tbc_roomdb_assign20.data.local.dao.UserDao
import com.example.tbc_roomdb_assign20.data.local.mapper.toData
import com.example.tbc_roomdb_assign20.data.local.mapper.toDomain
import com.example.tbc_roomdb_assign20.domain.model.User
import com.example.tbc_roomdb_assign20.domain.repository.IUserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserDaoImpl @Inject constructor(private val dao: UserDao) : IUserRepository {
    override suspend fun getUsersNumber(): Int {
        return dao.getNumberOfUsers()

    }

    override suspend fun getUserByEmail(email: String): User {
        return dao.getUserEmail(email).toDomain()
    }

    override suspend fun deleteUser(user: User) {
        return dao.deleteUser(user.toData())
    }

    override suspend fun insertUser(user: User) {
        return dao.insertUser(user.toData())
    }

    override suspend fun updateUser(user: User) {
        return dao.updateUser(user.toData())
    }
}