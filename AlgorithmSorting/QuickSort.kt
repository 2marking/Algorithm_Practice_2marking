var i = 0
var size = 0
fun partition(a: IntArray, begin: Int, end: Int): Int {
    val pivot: Int
    var temp: Int
    var L: Int
    var R: Int
    i++ //연산 횟수
    L = begin
    R = end
    pivot = ((begin + end) / 2)
    println(i.toString() + "단계: pivot=" + a[pivot])
    //1. while(L<R)인경우
    while (L < R) {
        while (a[L] <= a[pivot] && L <= R) L++
        while (a[R] > a[pivot] && L <= R) R--
        if (L <= R) {
            temp = a[L]
            a[L] = a[R]
            a[R] = temp
            if (R == pivot) { // L과 R 원소를 교환하여 결과적으로 pivot 원소의 위치가 변경된 경우
                for (t in 0 until size) {
                    print(a[t].toString() + " ")
                }
                println()
                return L // L은 확정된 pivot의 위치
            }
        }
    }
    //2. while(L>R)인 경우
    temp = a[pivot]
    a[pivot] = a[R]
    a[R] = temp
    for (t in 0 until size) {
        print(a[t].toString() + " ")
    }
    println()
    return R //R은 확
}

fun quickSort(a: IntArray, begin: Int, end: Int) {
    if (begin < end) {
        val p = partition(a, begin, end)
        quickSort(a, begin, p - 1) // pivot의 왼쪽 부분집합에 대해 퀵 정렬 재귀호출
        quickSort(a, p + 1, end) //pivot의 오른쪽 부분집합에 대해 퀵 정렬 재귀호출
    }
}

fun main(args: Array<String>) {
    val list = intArrayOf(69, 10, 30, 2, 16, 8, 31, 22)
    size = list.size
    quickSort(list, 0, size - 1)
}