package com.example.tbc_roomdb_assign20.domain.use_case

import com.example.tbc_roomdb_assign20.domain.model.User
import com.example.tbc_roomdb_assign20.domain.repository.IUserRepository
import javax.inject.Inject

class AddUsersUseCase @Inject constructor(private val repository: IUserRepository) {

    suspend operator fun invoke(user: User){
        repository.insertUser(user)
    }
}