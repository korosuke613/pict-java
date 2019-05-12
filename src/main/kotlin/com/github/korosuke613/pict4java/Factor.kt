package com.github.korosuke613.pict4java

import com.sun.jna.StringArray
import java.util.*
import kotlin.collections.ArrayList

class FactorWeightsException(msg: String? = null): RuntimeException(msg)

data class Factor(val level: Int? = null,
                  val named_level: List<String>? = null,
                  val pairwise: Int = 2,
                  private val weights: IntArray? = null,
                  val name: String = "NoName") {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Factor

        if (level != other.level) return false
        if (pairwise != other.pairwise) return false
        if (!Arrays.equals(weights, other.weights)) return false
        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        var result = level ?: 0
        result = 31 * result + (named_level?.hashCode() ?: 0)
        result = 31 * result + pairwise
        result = 31 * result + (weights?.let { Arrays.hashCode(it) } ?: 0)
        result = 31 * result + name.hashCode()
        return result
    }

    val safeWeights: IntArray?
        get(){
            return when {
                weights == null -> null
                weights.size == level -> weights
                else -> throw FactorWeightsException("The number of factors and the number of weights are different.")
            }
        }
    val safeLevel: Int
        get() {
            return when {
                level != null -> level
                else -> named_level!!.size
            }
        }
}
