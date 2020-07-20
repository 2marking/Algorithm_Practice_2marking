package leetcode

import java.util.concurrent.ThreadLocalRandom
import kotlin.random.Random


fun main(args: Array<String>) {
    val solutionArray = intArrayOf(1, 2, 3, 4, 5, 6, 16, 15, 14, 13, 12, 11)
    shuffleArray(solutionArray)
    for (i in solutionArray.indices) {
        print(solutionArray[i].toString() + " ")
    }
    println()
}

// Implementing Fisher–Yates shuffle
fun shuffleArray(ar: IntArray) { // If running on Java 6 or older, use `new Random()` on RHS here
    val rnd: ThreadLocalRandom? = ThreadLocalRandom.current()
    for (i in ar.size - 1 downTo 1) {
        val index: Int = rnd!!.nextInt(i + 1)
        // Simple swap
        val a = ar[index]
        ar[index] = ar[i]
        ar[i] = a
    }
}

//https://heowc.dev/programming-study/repo/java/random_class.html