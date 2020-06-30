internal class Solution {
    fun productExceptSelf(nums: IntArray): IntArray { // The length of the input array
        val length = nums.size
        // The left and right arrays as described in the algorithm
        val L = IntArray(length)
        val R = IntArray(length)
        // Final answer array to be returned
        val answer = IntArray(length)
        L[0] = 1
        for (i in 1 until length) { // L[i - 1] already contains the product of elements to the left of 'i - 1'
            L[i] = nums[i - 1] * L[i - 1]
        }
        R[length - 1] = 1
        for (i in length - 2 downTo 0) { // R[i + 1] already contains the product of elements to the right of 'i + 1'
            R[i] = nums[i + 1] * R[i + 1]
        }
        for (i in 0 until length) { // For the first element, R[i] would be product except self
            answer[i] = L[i] * R[i]
        }
        return answer
    }
}