data class makeSentence(val type: String, val uuid: String)

class Solution {
    fun solution(record: Array<String>): Array<String> {
        var chatArrayList: ArrayList<makeSentence> = arrayListOf()
        var chatHashMap: HashMap<String, String> = hashMapOf()

        for (i in record){
            val dataSplit = i.split(" ")
            when(dataSplit[0]){
                "Enter","Change"->chatHashMap.set(dataSplit[1],dataSplit[2])
            }
            when(dataSplit[0]){
                "Enter","Leave"->chatArrayList.add(makeSentence(dataSplit[0],dataSplit[1]))
            }
        }
        val answer = Array(chatArrayList.size) { i -> ""  }
        for (i in 0 until chatArrayList.size){
            val currentType = chatArrayList[i].type
            val currentUUID = chatArrayList[i].uuid
            val result:String? = chatHashMap.get(currentUUID)
            when(currentType){
                "Enter" -> answer[i]=result+"님이 들어왔습니다."
                "Leave" -> answer[i]=result+"님이 나갔습니다."
            }
        }
        return answer
    }
}
