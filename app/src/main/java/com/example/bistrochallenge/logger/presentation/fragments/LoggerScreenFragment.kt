package com.example.bistrochallenge.logger.presentation.fragments

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bistrochallenge.R
import com.example.bistrochallenge.logger.presentation.viewmodels.LoggerScreenViewModel

class LoggerScreenFragment : Fragment() {

    companion object {
        fun newInstance() = LoggerScreenFragment()
    }

    private val viewModel: LoggerScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_logger_screen, container, false)
    }
}