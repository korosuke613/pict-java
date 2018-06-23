package korosuke613.pict

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class PictTest{
    companion object {
        private val p = Pict()
    }
    private val collectData = listOf(intArrayOf(0, 2, 0, 2),
            intArrayOf(1, 1, 0, 0),
            intArrayOf(2, 1, 0, 4),
            intArrayOf(1, 2, 0, 4),
            intArrayOf(0, 3, 0, 1),
            intArrayOf(2, 2, 0, 1),
            intArrayOf(0, 1, 0, 1),
            intArrayOf(1, 0, 0, 1),
            intArrayOf(2, 0, 0, 0),
            intArrayOf(1, 1, 0, 2),
            intArrayOf(2, 3, 0, 0),
            intArrayOf(0, 2, 0, 0),
            intArrayOf(1, 1, 0, 3),
            intArrayOf(0, 3, 0, 4),
            intArrayOf(0, 0, 0, 3),
            intArrayOf(0, 0, 0, 4),
            intArrayOf(2, 2, 0, 3),
            intArrayOf(2, 3, 0, 2),
            intArrayOf(1, 0, 0, 2),
            intArrayOf(1, 3, 0, 3) )

    @BeforeEach
    fun init(){
        val model = Model()
        val f1 = Factor(3, weights = intArrayOf(1, 2, 1), name = "First Factor")
        val f2 = Factor(4, pairwise = 2,name = "Second Factor")
        val f3 = Factor(2, name = "Third Factor")
        val f4 = Factor(5, name = "Force Factor")
        model.addFactor(f1)
        model.addFactor(f2)
        model.addFactor(f3)
        model.addFactor(f4)
        p.setRootModel(model)
    }

    @Test
    fun generateData(){
        val tests = p.generate()

        for(test in tests){
            print("arrayOf(")
            test.forEach { print("$it, ") }
            println("), ")
        }
        println("test case size = ${tests.size}")
    }

    @Test
    fun generateTest() {
        val tests = p.generate()
        for ((index, test) in tests.withIndex()) {
            assertArrayEquals(test, collectData[index])
        }
    }
}