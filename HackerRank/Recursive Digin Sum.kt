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

// Complete the superDigit function below.
fun superDigit(n: String, k: Int): Int {
    var inputDataString = 0
    var refreshNumber = solution(n)

    for (i in 0 until k) inputDataString+=refreshNumber

    return solution(inputDataString.toString())
}

fun solution(n: String): Int{
    var answer = 0
    return if (n.length == 1) return n.toInt()
    else {
        for (i in 0 until n.length) answer += n.substring(i, i + 1).toInt()
        if (answer < 10) return answer
        else solution(answer.toString())
    }
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nk = scan.nextLine().split(" ")

    val n = nk[0]

    val k = nk[1].trim().toInt()

    val result = superDigit(n, k)
    println(result)
}
