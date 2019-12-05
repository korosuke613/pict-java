package korosuke613.pict4java

import korosuke613.pict4java.Factor
import korosuke613.pict4java.Model
import korosuke613.pict4java.Pict
import com.sun.jna.StringArray
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.collections.ArrayList

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
        val namedLevel: ArrayList<Long> = arrayListOf(-121212, 0, 3233252)
        val f5 = Factor(named_level = namedLevel.map { it.toString() }, name = "Fifth Factor")
        model.addFactor(f1)
        model.addFactor(f2)
        model.addFactor(f3)
        model.addFactor(f4)
        model.addFactor(f5)
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
        var namedLevel: ArrayList<Long> = arrayListOf(2147483648, 2147483647, -2147483648, -2147483649, 2, 3)
        val f1 = Factor(named_level = namedLevel.map { it.toString() }, name = "a")
        namedLevel = arrayListOf(4294967295, 4294967294, 0, -1, 1)
        val f2 = Factor(named_level = namedLevel.map { it.toString() }, name = "b")
        namedLevel = arrayListOf(4294967296, 4294967295, 1, 0, 99, 100)
        val f3 = Factor(named_level = namedLevel.map { it.toString() }, name = "c")
        val model = Model()
        model.addFactor(f1)
        model.addFactor(f2)
        model.addFactor(f3)
        val p = Pict()
        p.setRootModel(model)
        val tests = p.generate()
        for ((index, test) in tests.withIndex()) {

        }
    }
}