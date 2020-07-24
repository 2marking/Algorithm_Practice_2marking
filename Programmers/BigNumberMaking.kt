import java.util.Stack

fun main(args: Array<String>) {
    println(getBigNum("1924"))

//    ["d@co@m.com", "a@abc.com", "b@def.com", "c@ghi.net"]	3
//    ["abc.def@x.com", "abc", "abc@defx", "abc@defx.xyz"]
}


fun getBigNum(number: String, k: Int): String {
    val answerBuilder = StringBuilder()
    with(number.toCharArray()) {
        var remainLetterCount = number.length - k
        var left = 0
        while(remainLetterCount != 0) {
            if(remainLetterCount == size - left) {
                for(eachIndex in left .. size - 1) answerBuilder.append(this[eachIndex])
                return answerBuilder.toString()
            }
            var frontSubMaxValue = '/'
            var frontSubMaxIndex = -1
            for(eachIndex in left .. size - remainLetterCount) {
                if(frontSubMaxValue < this[eachIndex]) {
                    frontSubMaxValue = this[eachIndex]
                    frontSubMaxIndex = eachIndex
                }
            }
            answerBuilder.append(frontSubMaxValue)
            remainLetterCount--
            left = frontSubMaxIndex + 1
        }
    }
    return answerBuilder.toString()
}

