package com.github.korosuke613.pict4java

import com.sun.jna.Pointer
import korosuke613.pict4java.LibPict


class Pict {
    private lateinit var task: Pointer
    private lateinit var model: Model

    init {
        createTask()
    }

    private fun createTask(){
        task = p.PictCreateTask()
    }

    fun setRootModel(model_: Model) {
        model = model_
        p.PictSetRootModel(task, model_.model)
    }

    fun generate(): List<Array<String?>> {
        p.PictGenerate(task)

        val resultRef = p.PictAllocateResultBuffer(task)
        val paramCount = p.PictGetTotalParameterCount(task)
        p.PictResetResultFetching(task)

        var count = 0

        val mutableTestData = mutableListOf<Array<String?>>()
        while (p.PictGetNextResultRow(task, resultRef) > 0) {
            val rowRef = resultRef.pointer
            val row = rowRef.getLongArray(0, paramCount)
            val t: Array<String?> = arrayOfNulls(paramCount)
            for (index in 0 until paramCount) {
                if (model.isNamedLevelFactor(index)) {
                    val name = model.getNamedLevelFactor(index)
                    t[index] = name[row[index].toInt()]
                } else {
                    t[index] = row[index].toString()
                }
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

