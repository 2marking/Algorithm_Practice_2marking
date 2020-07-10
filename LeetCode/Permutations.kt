package leetcode

import java.lang.Exception

fun main(args: Array<String>) {
    val inputData = intArrayOf(5,1,9,11)
    println(permute(inputData))
}
private val result: MutableList<List<Int>> = mutableListOf()

fun permute(nums: IntArray): List<List<Int>> {
    permuteAux(mutableListOf(), nums.toList())
    return result
}

private fun permuteAux(added: List<Int>, left: List<Int>) {
    if (left.isEmpty()) {
        result.add(added)
    } else {
        left.forEach { candidate ->
            permuteAux(added + candidate, left - candidate)
        }
    }
}