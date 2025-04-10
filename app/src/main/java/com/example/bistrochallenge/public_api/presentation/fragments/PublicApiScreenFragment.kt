package com.example.bistrochallenge.public_api.presentation.fragments

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bistrochallenge.R
import com.example.bistrochallenge.public_api.presentation.viewmodels.PublicApiScreenViewModel

class PublicApiScreenFragment : Fragment() {

    companion object {
        fun newInstance() = PublicApiScreenFragment()
    }

    private val viewModel: PublicApiScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_public_api_screen, container, false)
    }
}