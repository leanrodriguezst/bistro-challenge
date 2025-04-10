package com.example.bistrochallenge.factorial.presentation.fragments

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bistrochallenge.R
import com.example.bistrochallenge.databinding.FragmentFactorialScreenBinding
import com.example.bistrochallenge.factorial.presentation.viewmodels.FactorialScreenViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FactorialScreenFragment : Fragment() {

    companion object {
        fun newInstance() = FactorialScreenFragment()
    }

    private val viewModel: FactorialScreenViewModel by viewModels()

    private lateinit var _binding: FragmentFactorialScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFactorialScreenBinding.inflate(inflater, container, false)
        handleObservables()
        handleListeners()
        return _binding.root
    }

    private fun handleListeners() {
        _binding.button.setOnClickListener {
            val number = _binding.editText.text.toString().toIntOrNull() ?: return@setOnClickListener
            if (number < 0) return@setOnClickListener
            viewModel.calculateFactorial(number)
        }
    }

    private fun handleObservables() {
        viewModel.factorialResult.observe(viewLifecycleOwner) { result ->
            _binding.resultNumber.text = result.toString()
        }
    }
}