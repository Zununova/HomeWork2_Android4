package com.example.homework1_android4.ui.fragments.login

import android.widget.Toast
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.homework1_android4.R
import com.example.homework1_android4.base.BaseFragment
import com.example.homework1_android4.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding, LogInViewModel>(R.layout.fragment_login) {
    override val binding by viewBinding(FragmentLoginBinding::bind)
    override val viewModel: LogInViewModel by viewModels()

    override fun setupSubscribes() {

        viewModel.fetchToken().observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), it.data?.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}


