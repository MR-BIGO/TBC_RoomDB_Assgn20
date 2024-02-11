package com.example.tbc_roomdb_assign20.presentation.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tbc_roomdb_assign20.domain.use_case.CollectionUseCase
import com.example.tbc_roomdb_assign20.presentation.event.HomeFragmentEvent
import com.example.tbc_roomdb_assign20.presentation.mapper.toDomain
import com.example.tbc_roomdb_assign20.presentation.model.UserPresentation
import com.example.tbc_roomdb_assign20.presentation.state.home.HomeFragmentState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(private val useCases: CollectionUseCase) :
    ViewModel() {

    private val _homeState = MutableStateFlow(HomeFragmentState())
    val homeState: SharedFlow<HomeFragmentState> = _homeState.asStateFlow()

    init {
        getUsersAmount()
    }

    fun onEvent(event: HomeFragmentEvent) {
        when (event) {
            is HomeFragmentEvent.AddUserPressed -> addUser(event.user)

            is HomeFragmentEvent.DeleteUserPressed -> deleteUser(event.user)

            is HomeFragmentEvent.UpdateUserPressed -> updateUser(event.user)

            is HomeFragmentEvent.ResetError -> setError(null)

            is HomeFragmentEvent.ResetMessage -> setMessage(null)
        }
    }

    private fun addUser(user: UserPresentation) {
        viewModelScope.launch {
            try {
                useCases.addUser(user.toDomain())
                setMessage("User added successfully!")
            } catch (e: Throwable) {
                setError(e.message)
            }
        }
        getUsersAmount()
    }

    private fun deleteUser(user: UserPresentation) {
        viewModelScope.launch {
            try {
                useCases.deleteUser(user.toDomain())
                setMessage("User deleted successfully!")
            } catch (e: Throwable) {
                setError(e.message)
            }
        }
        getUsersAmount()
    }

    private fun updateUser(user: UserPresentation) {
        viewModelScope.launch {
            try {
                useCases.updateUser(user.toDomain())
                setMessage("User updated successfully!")
            } catch (e: Throwable) {
                setError(e.message)
            }
        }
        getUsersAmount()
    }

    private fun setError(error: String?) {
        _homeState.update { currentState -> currentState.copy(error = error) }
    }

    private fun setMessage(message: String?) {
        _homeState.update { currentState -> currentState.copy(message = message) }
    }

    private fun getUsersAmount() {
        viewModelScope.launch {
            val count = useCases.getUsersAmount()
            _homeState.update { currentState -> currentState.copy(usersCount = count) }
        }
    }
}