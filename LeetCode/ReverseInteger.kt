package leetcode

import java.lang.Exception

fun main(args: Array<String>) {
    println(num_reverse(1534236469))
}

fun num_reverse(x: Int): Int {
    var inputNumber = x
    if (inputNumber<0) inputNumber *= -1

    if (x<10 && x>-10) return inputNumber

    var answer = ""
    var check = false

    while(true){
        val currentData = inputNumber%10
        if (currentData!=0 || check){
            answer+=currentData
            check=true
        }

        inputNumber /= 10
        if (inputNumber<10) {
            answer+=inputNumber
            break
        }
    }

    return try {
        if (x<0) answer.toInt()*-1
        else answer.toInt()
    } catch (e: NumberFormatException){
        0
    } catch (e: Exception){
        0
    }
}