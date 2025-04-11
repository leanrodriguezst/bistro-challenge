package com.example.bistrochallenge.logger.presentation.fragments

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bistrochallenge.R
import com.example.bistrochallenge.databinding.FragmentLoggerScreenBinding
import com.example.bistrochallenge.logger.presentation.adapter.EventsAdapter
import com.example.bistrochallenge.logger.presentation.viewmodels.LoggerScreenViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoggerScreenFragment : Fragment() {

    companion object {
        fun newInstance() = LoggerScreenFragment()
    }

    private val viewModel: LoggerScreenViewModel by viewModels()

    private lateinit var _binding: FragmentLoggerScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.logState(
            lifeCycleType = "onCreate"
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoggerScreenBinding.inflate(inflater, container, false)
        viewModel.logState(
            lifeCycleType = "onCreateView"
        )
        viewModel.getLogStates()
        handleObservables()
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.logState(
            lifeCycleType = "onViewCreated"
        )
    }

    override fun onStart() {
        super.onStart()
        viewModel.logState(
            lifeCycleType = "onStart"
        )
    }

    override fun onResume() {
        super.onResume()
        viewModel.logState("onResume")
    }

    override fun onPause() {
        viewModel.logState("onPause")
        super.onPause()
    }

    override fun onStop() {
        viewModel.logState("onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        viewModel.logState("onDestroyView")
        super.onDestroyView()
    }

    override fun onDestroy() {
        viewModel.logState("onDestroy")
        super.onDestroy()
    }

    private fun handleObservables() {
        viewModel.logStates.observe(viewLifecycleOwner) { logStates ->
            val rv = _binding.recyclerView
            rv.layoutManager = LinearLayoutManager(requireContext())
            rv.adapter = EventsAdapter(logStates)
            rv.setHasFixedSize(true)
        }
    }
}