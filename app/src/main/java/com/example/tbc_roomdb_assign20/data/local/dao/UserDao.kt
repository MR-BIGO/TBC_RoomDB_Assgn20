package com.example.tbc_roomdb_assign20.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.tbc_roomdb_assign20.data.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT COUNT(email) FROM users_info")
    suspend fun getNumberOfUsers(): Int

    @Query("SELECT * FROM users_info where email LIKE :email")
    suspend fun getUserEmail(email: String): UserEntity

    @Delete
    suspend fun deleteUser(user: UserEntity)

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertUser(user: UserEntity)

    @Update
    suspend fun updateUser(user: UserEntity)
}