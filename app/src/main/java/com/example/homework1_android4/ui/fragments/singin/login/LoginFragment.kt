package com.example.homework1_android4.ui.fragments.singin.login

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.homework1_android4.R
import com.example.homework1_android4.base.BaseFragment
import com.example.homework1_android4.data.models.login.LogDataModel
import com.example.homework1_android4.databinding.FragmentLoginBinding
import com.example.homework1_android4.utils.PreferenceHelper
import com.example.homework1_android4.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding, LogInViewModel>(R.layout.fragment_login) {
    override val binding by viewBinding(FragmentLoginBinding::bind)
    override val viewModel: LogInViewModel by viewModels()

    override fun setupListener() {
        binding.btnSingin.setOnClickListener {
            viewModel.fetchToken(
                LogDataModel(
                    "password",
                    binding.etInputLog.text.toString(),
                    binding.etInputPassword.text.toString()
                )
            ).observe(viewLifecycleOwner) {
                when (it) {
                    is Resource.Error -> Toast.makeText(
                        requireContext(),
                        it.message,
                        Toast.LENGTH_SHORT
                    ).show()
                    is Resource.Loading -> Toast.makeText(
                        requireContext(),
                        "Loading",
                        Toast.LENGTH_SHORT
                    ).show()
                    is Resource.Success -> {
                        requireActivity().findNavController(R.id.fragment_container)
                            .navigate(R.id.action_registerFragment_to_mainFragment)
                    }
                }

            }
        }
    }
}


