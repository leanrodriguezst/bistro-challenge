package com.example.bistrochallenge.factorial.presentation.interfaces

import java.math.BigInteger

interface CalculateFactorialUseCase {
    fun invoke(number: Int): BigInteger
}