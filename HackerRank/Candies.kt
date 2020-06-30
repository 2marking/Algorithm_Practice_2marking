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

// Complete the candies function below.
fun candies(n: Int, arr: Array<Int>): Long {
    var result:Long = 0
    var sendValue:Int = 1
    var descendValue:Int = 1
    var testResult: Array<Int?> = kotlin.arrayOfNulls<Int>(n)

    var i = 0
    while(i<n-1){
        if (arr[i]>arr[i+1]){
            sendValue = 1
            for (j in i until arr.size-1){
                if (arr[j]>arr[j+1]) {
                    testResult[j] = sendValue
                    result+=sendValue
                } else {
                    result+=sendValue
                    i+=sendValue-1
                    break
                }
                sendValue++
            }
            if (sendValue==arr.size-i) break
            println("sendValue: $sendValue")
        } else {
            descendValue = 1
            for (j in i until arr.size-1){
                if (arr[j]<arr[j+1]) {
                    testResult[j]=descendValue
                    result+=descendValue
                } else {
                    result+=descendValue
                    i+=descendValue-1
                    break
                }
                descendValue++
            }
            if (descendValue==arr.size-i) break
            println("descendValue: $descendValue")
        }

        println("정리 ----------")
        println("sendValue : $sendValue")
        println("descendValue : $descendValue")
        println("-----------")

    }
    println("----------------")
    for (i in testResult) println(i)
    println("----------------")

    return result
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val arr = Array<Int>(n, { 0 })
    for (i in 0 until n) {
        val arrItem = scan.nextLine().trim().toInt()
        arr[i] = arrItem
    }

    val result = candies(n, arr)
    print("Total Count : ")
    println(result)
}
