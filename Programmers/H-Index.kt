class Solution {
    fun solution(citations: IntArray): Int {
        var answer = 0
        var decendInput = citations.sortedArrayDescending()
        var check = 0

        for (j in citations.size downTo 1){
            for (i in decendInput) if (i>=j) check++
            if (check>=j) {
                answer = j
                break
            }
            check=0
        }
        return answer
    }
}