package com.example.tbc_roomdb_assign20.domain.use_case

import com.example.tbc_roomdb_assign20.domain.repository.IUserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllUsersUseCase @Inject constructor(private val repository: IUserRepository) {

    suspend operator fun invoke(): Int {
        return repository.getUsersNumber()

    }
}