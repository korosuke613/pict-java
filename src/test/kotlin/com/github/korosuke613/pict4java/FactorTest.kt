package com.github.korosuke613.pict4java

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class FactorTest {

    @Test
    fun createTest(){
        val factor = Factor(3)
        factor.name
    }

    @Test
    fun weightsTest(){
        val factor = Factor(3, weights = intArrayOf(1, 2, 3))
        factor.safeWeights
    }

    @Test
    fun weightExceptionTest(){
        val factor = Factor(3, weights = intArrayOf(1, 2, 3, 4))
        val exception = assertThrows(FactorWeightsException::class.java){
            factor.safeWeights
        }

        assertEquals("The number of factors and the number of weights are different.", exception.message)
    }

    @Test
    fun namedLevelTest() {
        val namedLevel: ArrayList<Long> = arrayListOf(-121212, 0, 3233252)
        val factor = Factor(named_level = namedLevel.map { it.toString() }, name = "その1")
    }
}