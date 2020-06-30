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

// Complete the gridlandMetro function below.

fun gridlandMetro(n: Int, m: Int, k: Int, track: Array<Array<Int>>): BigInteger? {
    var resolveArray = Array<IntArray>(n) {IntArray(m)}
    var answer = BigInteger.valueOf(0)
    for (i in 0 until k){
        for (j in track[i][1]..track[i][2]){
            resolveArray[track[i][0]-1][j-1] = 1
        }
    }
    for (i in resolveArray){
        for (j in i){
            if (j==0) answer++
        }
    }
    return answer
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nmk = scan.nextLine().split(" ")

    val n = nmk[0].trim().toInt()

    val m = nmk[1].trim().toInt()

    val k = nmk[2].trim().toInt()

    val track = Array<Array<Int>>(k, { Array<Int>(3, { 0 }) })

    for (i in 0 until k) {
        track[i] = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
    }

    val result = gridlandMetro(n, m, k, track)

    println(result)
}
