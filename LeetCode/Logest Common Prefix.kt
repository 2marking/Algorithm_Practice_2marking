package leetcode

import java.lang.Exception

fun main(args: Array<String>) {
    val stra:Array<String> = arrayOf("a")
    println(longestCommonPrefix(stra))
}

fun longestCommonPrefix(strs: Array<String>): String {
    var min = 100
    var resultPrefix = ""
    var tempPrefix = strs[0].substring(0,1)
    val inputSize = strs.size

    if (strs.isEmpty() || strs[0].isEmpty()) return ""

    for (i in strs) if (i.length <= min) min = i.length

    for (i in 1 .. min){
        var checkSize = 0
        var checkCurrentData = ""
        for (j in strs){
            checkCurrentData = j.substring(0,i)
            if (tempPrefix.equals(checkCurrentData)){
                checkSize++
            } else {
                break
            }
        }
        if (checkSize==inputSize){
            resultPrefix = checkCurrentData
            if (strs[0].length>=i+1){
                tempPrefix = strs[0].substring(0,i+1)
            } else break
        } else {
            break
        }
    }

    return resultPrefix
}
