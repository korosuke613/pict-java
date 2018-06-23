package korosuke613.pict

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class FactorTest {

    @Test
    fun createTest(){
        val factor = Factor(3)
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
}