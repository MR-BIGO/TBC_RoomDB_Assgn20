package com.example.tbc_roomdb_assign20.presentation.screen.home

import androidx.fragment.app.viewModels
import com.example.tbc_roomdb_assign20.databinding.FragmentHomeBinding
import com.example.tbc_roomdb_assign20.presentation.screen.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val viewModel: HomeFragmentViewModel by viewModels()
    override fun setUp() {

    }

}