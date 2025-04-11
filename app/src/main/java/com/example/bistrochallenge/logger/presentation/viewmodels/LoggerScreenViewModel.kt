package com.example.bistrochallenge.logger.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bistrochallenge.logger.domain.LifecycleEvent
import com.example.bistrochallenge.logger.presentation.interfaces.GetLogStatesUseCase
import com.example.bistrochallenge.logger.presentation.interfaces.LogStateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoggerScreenViewModel @Inject constructor(
    private val _logStateUseCase: LogStateUseCase,
    private val _getLogStatesUseCase: GetLogStatesUseCase
) : ViewModel() {

    private val _logStates: MutableLiveData<List<LifecycleEvent>> = MutableLiveData()
    val logStates: MutableLiveData<List<LifecycleEvent>> get() = _logStates

    fun logState(lifeCycleType: String) {
        viewModelScope.launch {
            val timestamp = System.currentTimeMillis()
            _logStateUseCase.invoke(
                lifeCycleType = lifeCycleType,
                timestamp = timestamp
            )
        }
    }

    fun getLogStates() {
        viewModelScope.launch {
            val logStates = _getLogStatesUseCase.invoke()
            _logStates.value = logStates
        }
    }

}