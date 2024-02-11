package com.example.tbc_roomdb_assign20.presentation.screen.home

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.tbc_roomdb_assign20.R
import com.example.tbc_roomdb_assign20.databinding.FragmentHomeBinding
import com.example.tbc_roomdb_assign20.presentation.event.HomeFragmentEvent
import com.example.tbc_roomdb_assign20.presentation.model.UserPresentation
import com.example.tbc_roomdb_assign20.presentation.screen.base.BaseFragment
import com.example.tbc_roomdb_assign20.presentation.state.home.HomeFragmentState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val viewModel: HomeFragmentViewModel by viewModels()
    override fun setUp() {
        listeners()
        bindObservers()
    }

    private fun listeners() = with(binding) {
        btnAddUser.setOnClickListener {
            if (checkFields()) {
                viewModel.onEvent(
                    HomeFragmentEvent.AddUserPressed(
                        UserPresentation(
                            etFirstName.text.toString(),
                            etLastName.text.toString(),
                            etAge.text.toString().toInt(),
                            etEmail.text.toString()
                        )
                    )
                )
            }
        }

        btnDeleteUser.setOnClickListener {
            if (checkFields()) {
                viewModel.onEvent(
                    HomeFragmentEvent.DeleteUserPressed(
                        UserPresentation(
                            etFirstName.text.toString(),
                            etLastName.text.toString(),
                            etAge.text.toString().toInt(),
                            etEmail.text.toString()
                        )
                    )
                )
            }
        }

        btnUpdateUser.setOnClickListener {
            if (checkFields()) {
                viewModel.onEvent(
                    HomeFragmentEvent.UpdateUserPressed(
                        UserPresentation(
                            etFirstName.text.toString(),
                            etLastName.text.toString(),
                            etAge.text.toString().toInt(),
                            etEmail.text.toString()
                        )
                    )
                )
            }
        }
    }

    private fun checkFields(): Boolean {
        with(binding) {
            if (etEmail.text!!.isNotEmpty() && etAge.text!!.isNotEmpty() && etFirstName.text!!.isNotEmpty() && etLastName.text!!.isNotEmpty()) {
                return true
            } else {
                setErrors()
                return false
            }
        }
    }

    private fun setErrors() = with(binding) {
        etEmail.error = getString(R.string.empty_field)
        etAge.error = getString(R.string.empty_field)
        etFirstName.error = getString(R.string.empty_field)
        etLastName.error = getString(R.string.empty_field)
    }

    private fun handleState(state: HomeFragmentState) = with(binding) {
        tvActiveUsers.text = getString(R.string.active_users).plus(" ${state.usersCount}")

        state.error?.let {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            viewModel.onEvent(HomeFragmentEvent.ResetError)
        }

        state.message?.let {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            viewModel.onEvent(HomeFragmentEvent.ResetMessage)
        }
    }

    private fun bindObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.homeState.collect {
                    handleState(it)
                }
            }
        }
    }
}