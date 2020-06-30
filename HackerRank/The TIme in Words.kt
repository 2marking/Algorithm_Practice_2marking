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

// Complete the timeInWords function below.
fun timeInWords(h: Int, m: Int): String {
    var answer = ""
    val clockHashMap:HashMap<Int,String> = hashMapOf(
        1 to "one",
        2 to "two",
        3 to "three",
        4 to "four",
        5 to "five",
        6 to "six",
        7 to "seven",
        8 to "eight",
        9 to "nine",
        10 to "ten",
        11 to "eleven",
        12 to "twelve",
        13 to "thirteen",
        14 to "fourteen",
        15 to "quarter",
        16 to "sixteen",
        17 to "seventeen",
        18 to "eighteen",
        19 to "nineteen",
        20 to "twenty",
        30 to "half")

    if (m==0) answer = clockHashMap[h] + " o' clock"
    else if (m>0 && m<=30){
        if (m==15 || m==30) answer = clockHashMap[m] + " past " + clockHashMap[h]
        else {
            if (m.div(10)==2){
                if (m==20) answer = "twenty " + "minutes past " + clockHashMap[h]
                else answer = "twenty " + clockHashMap[m.rem(10)] + " minutes past " + clockHashMap[h]
            } else {
                if (m==1) answer = clockHashMap[m] + " minute past " + clockHashMap[h]
                else answer = clockHashMap[m] + " minutes past " + clockHashMap[h]
            }
        }
    } else {
        val m = 60 - m
        if (m==15 || m==30) answer = clockHashMap[m] + " to " + clockHashMap[h+1]
        else {
            if (m.div(10)==2){
                if (m==20) answer = "twenty " + "minutes to " + clockHashMap[h+1]
                else answer = "twenty " + clockHashMap[m.rem(10)] + " minutes to " + clockHashMap[h+1]
            } else {
                if (m==1) answer = clockHashMap[m] + " minute to " + clockHashMap[h+1]
                else answer = clockHashMap[m] + " minutes to " + clockHashMap[h+1]
            }
        }
    }
    return answer


}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val h = scan.nextLine().trim().toInt()

    val m = scan.nextLine().trim().toInt()

    val result = timeInWords(h, m)

    println(result)
}
