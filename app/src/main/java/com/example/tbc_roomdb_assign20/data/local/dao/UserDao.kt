package com.example.tbc_roomdb_assign20.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.tbc_roomdb_assign20.domain.model.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT COUNT(*) FROM users")
    suspend fun getNumberOfUsers(): Flow<Int>

    @Delete
    suspend fun deleteUser(user: User)

    @Insert
    suspend fun insertUser(user: User)

    @Update
    suspend fun updateUser(user: User)
}