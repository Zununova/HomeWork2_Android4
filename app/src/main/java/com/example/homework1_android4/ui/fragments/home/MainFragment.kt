package com.example.homework1_android4.ui.fragments.home

import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.homework1_android4.R
import com.example.homework1_android4.databinding.FragmentMainBinding
import com.example.homework1_android4.utils.PreferenceHelper
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding by viewBinding(FragmentMainBinding::bind)

    override fun onDestroyView() {
        super.onDestroyView()
        setPreferenceData()
    }

    private fun setPreferenceData() {
        val preferenceHelper = PreferenceHelper()
        preferenceHelper.unit(requireContext())
        preferenceHelper.saveBoolean = true
    }
}