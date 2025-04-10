package com.example.bistrochallenge.public_api.presentation.fragments

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.bistrochallenge.R
import com.example.bistrochallenge.databinding.FragmentPublicApiScreenBinding
import com.example.bistrochallenge.public_api.presentation.viewmodels.PublicApiScreenViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PublicApiScreenFragment : Fragment() {

    companion object {
        fun newInstance() = PublicApiScreenFragment()
    }

    private val viewModel: PublicApiScreenViewModel by viewModels()

    private lateinit var _binding: FragmentPublicApiScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPublicApiScreenBinding.inflate(inflater, container, false)
        handleObservables()
        handleListeners()
        return _binding.root
    }

    private fun handleListeners() {
        _binding.fetchButton.setOnClickListener {
            viewModel.fetchImage()
        }
    }

    private fun handleObservables() {
        viewModel.imageUrl.observe(viewLifecycleOwner) { imageUrl ->
            Glide.with(this)
                .load(imageUrl)
                .placeholder(android.R.drawable.progress_indeterminate_horizontal)
                .error(android.R.drawable.stat_notify_error)
                .centerCrop()
                .into(_binding.imageView)

        }
    }

}