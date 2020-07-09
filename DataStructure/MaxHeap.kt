package AlgorithmSorting

import java.util.*

class MaxHeap {
    class maxheap {
        private val heap: ArrayList<Int> = ArrayList()
        fun insert(`val`: Int) {
            heap.add(`val`)
            var p = heap.size - 1
            while (p > 1 && heap[p / 2] < heap[p]) {
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
                var max = heap[pos * 2]
                var maxPos = pos * 2
                if (pos * 2 + 1 < heap.size && max < heap[pos * 2 + 1]) {
                    max = heap[pos * 2 + 1]
                    maxPos = pos * 2 + 1
                }
                if (heap[pos] > max) break
                val tmp = heap[pos]
                heap[pos] = heap[maxPos]
                heap[maxPos] = tmp
                pos = maxPos
            }
            return deleteItem
        }

        init {
            heap.add(1000000)
        }
    }
}



fun main(args: Array<String>){
    var heap:MaxHeap.maxheap = MaxHeap.maxheap()
    heap.insert(10)
    heap.insert(100)
    heap.insert(21)
    heap.insert(30)
}