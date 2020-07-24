import java.util.Stack

fun main(args: Array<String>) {
    println(getBigNum("1924",2))
}

fun getBigNum(number: String, k: Int): String {
    var answer = ""
    var stringSize = number.length - k
    var index = 0
    val list = mutableListOf<Char>()
    while (stringSize > 0) {
        val string = number.substring(index, number.length - (stringSize - 1))
        string.max()?.let {max ->
            index += string.indexOf(max) + 1
            list.add(max)
        }
        stringSize -= 1
    }
    answer = list.joinToString("")
    return answer
}