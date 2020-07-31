class Solution {
    fun solution(nums: IntArray): Int {
        var answer = 0

        for (i in 0 until nums.size-2){
            for (j in i+1 until nums.size-1){
                for (k in j+1 until nums.size){
                    var checkBit = true
                    val currentData = nums[i]+nums[j]+nums[k]
                    for (l in 2 until currentData/2){
                        if (currentData%l==0){
                            checkBit=false
                            break
                        }
                    }
                    if (checkBit) answer++
                }
            }
        }

        return answer
    }
}