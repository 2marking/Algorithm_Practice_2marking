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

// Complete the climbingLeaderboard function below.
fun climbingLeaderboard(scores: Array<Int>, alice: Array<Int>): ArrayList<Int> {
    var scoresHashSet:LinkedHashSet<Int> = linkedSetOf()
    for (i in scores) scoresHashSet.add(i)
    var testArray = scoresHashSet.toIntArray()

    var pivot = testArray[testArray.size/2]

    var resultAliceArray: ArrayList<Int> = arrayListOf()
    var rankCount = 0

    for (i in alice){
        if (i > pivot){
            for (j in 0 until testArray.size/2){
                if (testArray[j]>i) rankCount++
                else {
                    break
                }
            }
            rankCount++
        } else {
            for (j in testArray.size/2 until testArray.size){
                if (testArray[j]>i) rankCount++
                else {
                    break
                }
            }
            rankCount++
            rankCount+=testArray.size/2
        }
        resultAliceArray.add(rankCount)
        rankCount=0
    }
    return resultAliceArray
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val scoresCount = scan.nextLine().trim().toInt()

    val scores = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val aliceCount = scan.nextLine().trim().toInt()

    val alice = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val result = climbingLeaderboard(scores, alice)

    println(result.joinToString("\n"))
}
