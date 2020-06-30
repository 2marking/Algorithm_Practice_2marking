import sun.management.MemoryUsageCompositeData
import java.util.*
import java.util.Collections.max
import java.util.Collections.min
import kotlin.math.max

fun bubbleSort(inputData:IntArray): IntArray {
    var sortArray = inputData
    for (i in 0 until sortArray.size - 1) {
        for (j in i + 1 until sortArray.size) {
            if (sortArray[i] > sortArray[j]) {
                val temp = sortArray[i]
                sortArray[i] = sortArray[j]
                sortArray[j] = temp
            }
        }
    }
    return sortArray
}

fun selectionSort(arr: kotlin.IntArray): kotlin.IntArray {
    var result: kotlin.IntArray = arr
    var maxPos: Int
    for (i in 0 until result.size - 1) {
        maxPos = i
        for (k in i + 1 until result.size) {
            if (result[maxPos] > result[k]) {
                maxPos = k
            }
        }
        val temp = result[i]
        result[i] = result[maxPos]
        result[maxPos] = result[i]
    }
    return result
}

fun insertionSort(arr: IntArray): IntArray {
    var temp: Int
    for (i in 1 until arr.size) {
        temp = arr[i]
        var k: Int
        k = i - 1
        while (k >= 0) {
            if (temp >= arr[k]) {
                break
            }
            arr[k + 1] = arr[k]
            k--
        }
        arr[k + 1] = temp
    }
    return arr
}

fun mergeSort(array : IntArray, helper:IntArray = IntArray(array.size), low:Int = 0, high : Int = array.size-1) {
    if(low < high) {
        val middle:Int = (low+high)/2 // 2) calculating the middle element
        mergeSort(array, helper, low, middle) // 3) to sort left half
        mergeSort(array, helper, middle+1, high) // 4) to sort right half
        merge(array, helper, low, middle, high) // 5) Merge them
    }
}

fun merge (array: IntArray, helper: IntArray, low: Int, middle:Int, high: Int){
//    a) copying both halves into helper array
    for(i in low..high) helper[i] = array[i]

    var helperLeft = low
    var helperRight = middle + 1 // b) helper variables
    var current = low

    /*Iterate through helper array. Compare the left and right half, copying back the smaller element
    * from the two halves into original array*/

    while (helperLeft <= middle && helperRight <= high) { // c) condition to check helper left and helper right
        if(helper[helperLeft] <= helper[helperRight]) { // d) Check if value at helperLeft index is less than that of value at helper right
            array[current] = helper[helperLeft]
            helperLeft++
        } else { // e) right element is smaller than left element
            array[current] = helper[helperRight]
            helperRight++
        }
        current++
    }

//   f) copy the rest of leftside of array into target
    val remaining = middle - helperLeft
    for (i in 0..remaining) {
        array[current + i] = helper[helperLeft + i]
    }
}

//TODO Quick
fun quickSortCustom(arr: IntArray, left: Int, right: Int): IntArray {
    var result = arr
    if (left >= right) return result
    val pivotPos = partitionCustom(result, left, right)
    result = quickSortCustom(result, left, pivotPos - 1)
    result = quickSortCustom(result, pivotPos + 1, right)
    return result
}

fun partitionCustom(arr: IntArray?, left: Int, right: Int): Int {
    if (arr == null || left < 0) return -1
    val pivotValue = arr[right]
    var endOfLowBlock = left - 1
    for (pos in left until right) {
        if (pivotValue > arr[pos]) {
            endOfLowBlock += 1
            val temp = arr[pos]
            arr[pos] = arr[endOfLowBlock]
            arr[endOfLowBlock] = temp
        }
    }
    endOfLowBlock += 1
    val temp = arr[right]
    arr[right] = arr[endOfLowBlock]
    arr[endOfLowBlock] = temp
    return endOfLowBlock
}

//TODO CountingSOrt
fun countingSort(arr: IntArray): IntArray? {
    val max = max(arr.asList())
    val countArr = IntArray(max + 1) // 0 ~ max
    val resultArr = IntArray(arr.size) // 결과를 담을 배열
    // 배열에 있는 숫자들의 개수를 세어서 countArr에 저장
    for (i in arr.indices) {
        countArr[arr[i]]++
    }
    // countArr의 이전 값과 현재 값을 더하는 과정
    for (i in 1 until countArr.size) {
        countArr[i] += countArr[i - 1]
    }
    for (i in arr.indices.reversed()) {
        resultArr[--countArr[arr[i]]] =
            arr[i] // countArr[arr[i]]는 인자가 들어갈 n번째 자리이므로 실제 배열에서는 - 1을 한 Index가 되어야 한다.
    }
    return resultArr
}

//TODO 기수정렬

fun countSort(data: IntArray, exp: Int) {
    val output = IntArray(data.size)
    val count = IntArray(10)
    Arrays.fill(count, 0)
    // count 값 count배열에 저장
    for (i in data.indices) {
        count[data[i] / exp % 10]++
    }
    // count 값이 포함시켜 count배열에 저장
    for (i in 1..9) count[i] += count[i - 1]
    // output배열 빌드
    for (i in data.indices.reversed()) {
        output[count[data[i] / exp % 10] - 1] = data[i]
        count[data[i] / exp % 10]--
    }
    // output 배열에 저장된 값을 data 배열에 저장
    for (i in data.indices) {
        data[i] = output[i]
    }
}

fun radixsort(data: IntArray):IntArray { // 최대값 찾기
    val m = max(data.asList())
    var exp = 1
    while (m / exp > 0) {
        countSort(data, exp)
        exp *= 10
    }
    return data
}

fun main(args: Array<String>){
    val arr = intArrayOf(2, 1, 4, 0, 3)
    println("aaaaa")
    val sortedArr = IntArray(arr.size)
    for (i in sortedArr.indices) {
        sortedArr[i] = i
    }
    
    println("Bubble Sort result")
    println(Arrays.deepToString(arrayOf(bubbleSort(arr))))
    println("Selection Sort Result")
    println(Arrays.deepToString(arrayOf(selectionSort(arr))))
    println("Insertion Sort Result")
    println(Arrays.deepToString(arrayOf(insertionSort(arr))))
    println(Arrays.deepToString(arrayOf(arr)))
    println("Merge Sort Result")
    mergeSort(arr)

    val arrQuick = intArrayOf(2, 1, 4, 0, 3)
    println("Quick Sort Result")
    println(Arrays.deepToString(arrayOf(quickSortCustom(arrQuick, 0, arrQuick.size-1))))

    val arrCounting = intArrayOf(2,1,4,0,3)
    println("Couting Sort Result")
    println(Arrays.deepToString(arrayOf(countingSort(arrCounting))))

    val arrRadix = intArrayOf(2,1,4,0,3)
    println("Radix Sort Result")
    println(Arrays.deepToString(arrayOf(radixsort(arrRadix))))
}

