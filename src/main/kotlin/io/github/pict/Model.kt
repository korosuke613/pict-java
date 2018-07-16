package io.github.pict

class Model{
    private val p = LibPict.PictLib.INSTANCE
    var model = p.PictCreateModel()!!
    private val factors: MutableList<Factor> = mutableListOf()

    fun addFactor(factor: Factor){
        factors.add(factor)

        p.PictAddParameter(model,
                factor.level,
                factor.pairwise,
                factor.safeWeights)
    }

}