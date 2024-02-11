package com.example.tbc_roomdb_assign20.di

import com.example.tbc_roomdb_assign20.data.local.dao.UserDao
import com.example.tbc_roomdb_assign20.data.repository.local.UserDaoImpl
import com.example.tbc_roomdb_assign20.domain.repository.IUserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideUserRepository(dao: UserDao): IUserRepository {
        return UserDaoImpl(dao)
    }
}