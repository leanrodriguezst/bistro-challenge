package com.example.bistrochallenge.factorial.usecases

import com.example.bistrochallenge.factorial.presentation.interfaces.CalculateFactorialUseCase
import java.math.BigInteger

class CalculateFactorialUseCaseImpl: CalculateFactorialUseCase {
    override fun invoke(number: Int): BigInteger {
        var factorial = BigInteger.ONE
        for (i in 1..number) {
            factorial = factorial.multiply(BigInteger.valueOf(i.toLong()))
        }
        return factorial
    }
}