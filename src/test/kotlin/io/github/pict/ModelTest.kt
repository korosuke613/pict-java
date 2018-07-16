package io.github.pict

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach

internal class ModelTest {
    var model = Model()
    val f1 = Factor(3, weights = intArrayOf(1, 2, 1), name = "First Factor")
    val f2 = Factor(4, name = "Second Factor")
    val f3 = Factor(1, name = "Third Factor")
    val f4 = Factor(5, name = "Force Factor")

    @BeforeEach
    fun init(){
    }

    @Test
    fun addFactor() {
        model.addFactor(f1)
        model.addFactor(f2)
        model.addFactor(f3)
        model.addFactor(f4)
    }

    @Test
    fun getFactorWithNamedLevel() {
        val namedLevel: ArrayList<Long> = arrayListOf(-121212, 0, 3233252)
        val factor = Factor(named_level = namedLevel.map { it.toString() }, name = "その1")
        model.addFactor(factor)
        for ((i, _) in model.factors.withIndex()) {
            assertEquals(true, model.isNamedLevelFactor(i))
            assertEquals(namedLevel, model.getNamedLevelFactor(i))
        }
    }
}