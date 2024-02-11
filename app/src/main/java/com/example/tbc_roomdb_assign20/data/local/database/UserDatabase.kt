package com.example.tbc_roomdb_assign20.data.local.database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tbc_roomdb_assign20.data.local.dao.UserDao
import com.example.tbc_roomdb_assign20.data.local.entity.UserEntity

@Database(entities = [UserEntity::class],
    version = 1,
//    autoMigrations = [AutoMigration(from = 1, to = 2)],
//    exportSchema = true
  )
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
}