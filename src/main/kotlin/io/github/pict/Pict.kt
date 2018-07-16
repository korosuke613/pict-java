package io.github.pict

import com.sun.jna.Pointer


class Pict {
    private lateinit var task: Pointer

    init {
        createTask()
    }

    private fun createTask(){
        task = p.PictCreateTask()
    }

    fun setRootModel(model: Model){
        p.PictSetRootModel(task, model.model)
    }

    fun generate(): List<IntArray> {
        p.PictGenerate(task)

        val resultRef = p.PictAllocateResultBuffer(task)
        val paramCount = p.PictGetTotalParameterCount(task)
        p.PictResetResultFetching(task)

        var count = 0

        val mutableTestData = mutableListOf<IntArray>()
        while (p.PictGetNextResultRow(task, resultRef) > 0) {
            val rowRef = resultRef.pointer
            val row = rowRef.getLongArray(0, paramCount)
            val t = IntArray(paramCount)
            for (index in 0 until paramCount) {
                t[index] = row[index].toInt()
            }
            mutableTestData.add(t)
            count++
        }
        return mutableTestData.toList()
    }


    companion object {
        @JvmField
        internal var p = LibPict.PictLib.INSTANCE
    }
}

