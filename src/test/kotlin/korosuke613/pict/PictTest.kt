package korosuke613.pict

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.*

internal class PictTest {
    companion object {
        private val p = Pict()
    }

    @BeforeEach
    fun init() {
        val model = Model()
        val f1 = Factor(3, weights = intArrayOf(1, 2, 1), name = "First Factor")
        val f2 = Factor(4, name = "Second Factor")
        val f3 = Factor(2, name = "Third Factor")
        val f4 = Factor(5, name = "Force Factor")
        model.addFactor(f1)
        model.addFactor(f2)
        model.addFactor(f3)
        model.addFactor(f4)
        p.setRootModel(model)
    }

    @Test
    fun generateData() {
        val tests = p.generate()
        tests.sortedBy { it.hashCode() }

        for (test in tests) {
            print("intArrayOf(")
            test.forEach { print("$it, ") }
            println("), ")
        }
        println("test case size = ${tests.size}")
    }

    @Test
    fun generateTest() {
        val tests = p.generate()
        for ((index, test) in tests.withIndex()) {

        }
    }
}