package AlgorithmSorting

import java.util.*

class MinHeap {
    class minHeap {
        private val heap: ArrayList<Int>
        fun insert(`val`: Int) {
            heap.add(`val`)
            var p = heap.size - 1
            while (p > 1 && heap[p / 2] > heap[p]) {
                println("swap")
                val tmp = heap[p / 2]
                heap[p / 2] = heap[p]
                heap[p] = tmp
                p /= 2
            }
        }

        fun delete(): Int {
            if (heap.size - 1 < 1) {
                return 0
            }
            val deleteItem = heap[1]
            heap[1] = heap[heap.size - 1]
            heap.removeAt(heap.size - 1)
            var pos = 1
            while (pos * 2 < heap.size) {
                var min = heap[pos * 2]
                var minPos = pos * 2
                if (pos * 2 + 1 < heap.size && min > heap[pos * 2 + 1]) {
                    min = heap[pos * 2 + 1]
                    minPos = pos * 2 + 1
                }
                if (heap[pos] < min) break
                val tmp = heap[pos]
                heap[pos] = heap[minPos]
                heap[minPos] = tmp
                pos = minPos
            }
            return deleteItem
        }

        init {
            heap = ArrayList()
            heap.add(0)
        }
    }
}



fun main(args: Array<String>){
    var heap:MinHeap.minHeap = MinHeap.minHeap()
    heap.insert(10)
    heap.insert(100)
    heap.insert(21)
    heap.insert(30)
}