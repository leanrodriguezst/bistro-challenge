package com.example.bistrochallenge.factorial.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bistrochallenge.factorial.presentation.interfaces.CalculateFactorialUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import java.math.BigInteger
import javax.inject.Inject

@HiltViewModel
class FactorialScreenViewModel @Inject constructor(
    private val _calculateFactorialUseCase: CalculateFactorialUseCase,
) : ViewModel() {

    private val _factorialResult: MutableLiveData<BigInteger> = MutableLiveData()
    val factorialResult: LiveData<BigInteger> get() = _factorialResult

    init {
        _factorialResult.value = BigInteger.ZERO
    }

    fun calculateFactorial(number: Int) {
        _factorialResult.value = _calculateFactorialUseCase.invoke(number)
    }

}