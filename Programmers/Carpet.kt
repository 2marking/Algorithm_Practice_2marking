fun CPSolution(brown: Int, yellow: Int): IntArray {
    var answer = intArrayOf(3,3)
    if (yellow==1) {
        return answer
    }
    else{
        for (i in 1..yellow/2){
            if (yellow%i==0){
                val currentData = (i+yellow/i)*2+4
                if (currentData==brown){
                    if (i>=(yellow/i)){
                        answer[0]=i+2
                        answer[1]=(yellow/i)+2
                    } else {
                        answer[0]=(yellow/i)+2
                        answer[1]=i+2
                    }
                }
            }
        }
    }
    return answer
}