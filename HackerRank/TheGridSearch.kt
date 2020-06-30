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

/*
    문제 이해

*/

// Complete the gridSearch function below.
fun gridSearch(G: Array<String>, P: Array<String>): String {
    var currentGridLocation = 0
    var resultCount = 1
    val compareSize = P[0].length
    var answer = 0

    for (i in 0..G.size-P.size+1){
        for (j in 0..G[i].length - P[currentGridLocation].length){
            if (G[i].substring(j,j+compareSize)==P[currentGridLocation]){
                resultCount = 1
                for (k in 1 until P.size){
                    if (G[i+k].substring(j,j+compareSize) == P[k]) resultCount++
                }
            }
            if (resultCount==P.size) {
                answer=1
                break
            }
        }
        if (answer==1) break
    }
    return if (answer==1) "YES"
    else "NO"
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val t = scan.nextLine().trim().toInt()

    for (tItr in 1..t) {
        val RC = scan.nextLine().split(" ")

        val R = RC[0].trim().toInt()

        val C = RC[1].trim().toInt()

        val G = Array<String>(R, { "" })
        for (i in 0 until R) {
            val GItem = scan.nextLine()
            G[i] = GItem
        }

        val rc = scan.nextLine().split(" ")

        val r = rc[0].trim().toInt()

        val c = rc[1].trim().toInt()

        val P = Array<String>(r, { "" })
        for (i in 0 until r) {
            val PItem = scan.nextLine()
            P[i] = PItem
        }

        val result = gridSearch(G, P)

        println(result)
    }
}
