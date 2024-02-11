package com.example.tbc_roomdb_assign20.domain.use_case

import javax.inject.Inject

class CollectionUseCase @Inject constructor(
    val addUser: AddUsersUseCase,
    val updateUser: UpdateUserUseCase,
    val getUsersAmount: GetAllUsersUseCase,
    val getUserByEmail: GetUserByEmailUseCase,
    val deleteUser: DeleteUserUseCase
) {
}