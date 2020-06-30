fun main(args: Array<String>) {
    val s = "PAYPALISHIRING"
    val numRows = 3

    println(convert(s,numRows))
    val s1 = "AB"
    val numRows1 = 1

    println(convert(s1,numRows1))
}

fun convert(s: String, numRows: Int): String {
    if (numRows==1) return s
    else {
        var answer:String = ""
        var test = Array<String>(numRows, {""})
        var currentIndex = 0
        var testNum = 1

        for (i in 0 until s.length){
            test.set(currentIndex, test.get(currentIndex)+s.substring(i,i+1))
            currentIndex+=testNum
            if (currentIndex==numRows-1) testNum = -1
            if (currentIndex==0) testNum = 1
        }
        for (i in 0 until numRows){
            answer+=test.get(i)
        }
        //numRows+1
        return answer
    }
}