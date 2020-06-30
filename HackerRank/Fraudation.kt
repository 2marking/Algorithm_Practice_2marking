import java.util.*



fun countingSortt(ar: kotlin.IntArray, minVal: Int, maxVal: Int):IntArray {
    val sz = maxVal - minVal + 1
    val B = IntArray(sz)
    for (i in ar.indices) B[ar.get(i) - minVal]++
    var i = 0
    var k = 0
    while (i < sz) {
        while (B[i]-- > 0) ar[k++] = i + minVal
        i++
    }
    return ar
}
fun activityNotifications(expenditure: Array<Int>, d: Int): Int {
    var checkQueue:Queue<Int> = LinkedList()
    var answer = 0


    for (i in 0 until d) checkQueue.add(expenditure[i])

    var queueToArray = countingSortt(checkQueue.toIntArray(),0,200)
    var exDataList = queueToArray
    var exDataMiddle:Float = 0.0F
    if (d.rem(2)==0) exDataMiddle = (exDataList[d/2] + exDataList[d/2-1])/2.toFloat()
    else exDataMiddle = exDataList[d/2].toFloat()

    for (i in d until expenditure.size){
        if (expenditure[i] >= exDataMiddle*2) answer++
        checkQueue.remove()
        checkQueue.add(expenditure[i])
        var queueToArray = countingSortt(checkQueue.toIntArray(),0,200)
        var exDataList = queueToArray
        if (d.rem(2)==0) exDataMiddle = (exDataList[d/2] + exDataList[d/2-1])/2.toFloat()
        else exDataMiddle = exDataList[d/2].toFloat()
    }
    return answer
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nd = scan.nextLine().split(" ")

    val n = nd[0].trim().toInt()

    val d = nd[1].trim().toInt()

    val expenditure = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val result = activityNotifications(expenditure, d)

    println(result)
}
