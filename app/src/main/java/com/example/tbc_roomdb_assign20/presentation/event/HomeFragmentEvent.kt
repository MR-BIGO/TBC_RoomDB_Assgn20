package com.example.tbc_roomdb_assign20.presentation.event

import com.example.tbc_roomdb_assign20.presentation.model.UserPresentation

sealed class HomeFragmentEvent{
    data class AddUserPressed(val user: UserPresentation): HomeFragmentEvent()
    data class DeleteUserPressed(val user: UserPresentation): HomeFragmentEvent()
    data class UpdateUserPressed(val user: UserPresentation): HomeFragmentEvent()
    data object ResetError: HomeFragmentEvent()
    data object ResetMessage: HomeFragmentEvent()
}
