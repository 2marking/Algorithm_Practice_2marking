package leetcode

import java.lang.Exception

fun main(args: Array<String>) {
    println(romanToInteger("LVIII"))
}

fun romanToInteger(s: String): Int {
    var i = 0
    var answer = 0
    while(i<s.length){
        val currentIndexData = s.substring(i,i+1)

        if (i==s.length-1){
            answer += when(currentIndexData){
                "I" -> 1
                "V" -> 5
                "X" -> 10
                "L" -> 50
                "C" -> 100
                "D" -> 500
                "M" -> 1000
                else -> 0
            }
            return answer
        }

        val nextIndexData = s.substring(i+1,i+2)

        when(currentIndexData){
            "I" -> {
                answer += when(nextIndexData){
                    "V" -> {
                        i++
                        4
                    }
                    "X" -> {
                        i++
                        9
                    }
                    else -> 1
                }
            }
            "X" -> {
                answer += when(nextIndexData){
                    "L" -> {
                        i++
                        40
                    }
                    "C" -> {
                        i++
                        90
                    }
                    else -> 10
                }

            }
            "C" -> {
                answer += when(nextIndexData){
                    "D" -> {
                        i++
                        400
                    }
                    "M" -> {
                        i++
                        900
                    }
                    else -> 100
                }
            }
            "V" -> answer+=5
            "L" -> answer+=50
            "D" -> answer+=500
            "M" -> answer+=1000
        }
        i++
    }
    return answer
}