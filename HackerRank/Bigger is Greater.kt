import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

// Complete the biggerIsGreater function below.
fun biggerIsGreater(w: String): String {
    var reversedInputString:CharArray = w.toCharArray().reversedArray()
    val stringSize = reversedInputString.size
    var sortingCount = 0
    var sortingLocation = false
    var result = "no answer"
    for (i in 0 until stringSize) {
        val currentData = reversedInputString[i]
        for (j in 0 until i + 1) {
            val compareData = reversedInputString[j]
            if (currentData.toInt() < compareData.toInt()) {
                val temp = currentData
                reversedInputString[i] = reversedInputString[j]
                reversedInputString[j] = temp
                sortingLocation = true
                sortingCount = i
                break
            }
        }
        if (sortingLocation) {
            result = ""
            var sortingWord = reversedInputString.copyOfRange(0, sortingCount).sortedArray().reversedArray()
            for (element in sortingWord) result += element
            var sortingWord1 = reversedInputString.copyOfRange(sortingCount, stringSize)
            for (element in sortingWord1) result += element
            break
        }
    }
    return if (result == "no answer") result
    else result.reversed()
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val T = scan.nextLine().trim().toInt()

    for (TItr in 1..T) {
        val w = scan.nextLine()

        val result = biggerIsGreater(w)

        println(result)
    }
}