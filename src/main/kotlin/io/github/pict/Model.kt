package io.github.pict

class Model{
    private val p = LibPict.PictLib.INSTANCE
    var model = p.PictCreateModel()!!
    val factors: MutableList<Factor> = mutableListOf()

    fun addFactor(factor: Factor){
        factors.add(factor)

        p.PictAddParameter(model,
                factor.safeLevel,
                factor.pairwise,
                factor.safeWeights)
    }

    fun isNamedLevelFactor(index: Int): Boolean {
        return factors[index].named_level != null
    }

    fun getNamedLevelFactor(index: Int): List<String> {
        return factors[index].named_level!!
    }
}