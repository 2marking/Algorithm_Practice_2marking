import java.util.*


// Complete the hackerlandRadioTransmitters function below.
fun hackerlandRadioTransmitters(x: Array<Int>, k: Int): Int {
    var x = x.sortedArray()
    var numOfTransmitters = 0
    var i = 0
    val n=x.size
    while (i < n) {
        numOfTransmitters++
        var loc = x[i] + k
        while (i < n && x[i] <= loc) i++
        loc = x[--i] + k
        while (i < n && x[i] <= loc) i++
    }
    /*
    var sortedInputData = x.sortedArray()
    var checkArray = Array<Int>(sortedInputData.last()+k+1){0}

    for (i in sortedInputData) checkArray[i] = 1

    var i = sortedInputData.first()
    var answer = 0
    println(sortedInputData.last())
    while(i<=sortedInputData.last()) {
        if (checkArray[i]==0) i++
        else {
            if (checkArray[i+k]==0){
                var checkMode = false
                for (j in i+k downTo i){
                    if (checkArray[j]==1 ){
                        i+=i+k-j
                        checkMode=true
                        break
                    }
                }
                if (!checkMode) i++
            }
            else i += (2 * k) + 1
            answer++
        }
    }*/

    return numOfTransmitters
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nk = scan.nextLine().split(" ")

    val n = nk[0].trim().toInt()

    val k = nk[1].trim().toInt()

    val x = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val result = hackerlandRadioTransmitters(x, k)

    println(result)
}
