package DataStructure

object LinkedListDefault {
    @JvmStatic
    fun main(args: Array<String>) {
        val L = LinkedList()
        println("(1) 공백 리스트에 노드 3개 삽입하기")
        L.insertLastNode("월")
        L.insertLastNode("수")
        L.insertLastNode("일")
        L.printList()
        println("(2) 수 노드 뒤에 금 노드 삽입하기")
        val pre = L.searchNode("수")
        if (pre == null) println("검색 실패>> 찾는 데이터가 없다") else {
            L.insertMiddleNode(pre, "금")
            L.printList()
        }
        println("(3) 리스트의 노드를 역순으로 바꾸기")
        L.reverseList()
        L.printList()
        println("(4) 리스트의 마지막 노드 삭제하기")
        L.deleteLastNode()
        L.printList()
    }
}

internal class LinkedList {
    private var head: ListNode? = null
    fun insertMiddleNode(pre: ListNode, data: String?) {
        val newNode = ListNode(data)
        newNode.link = pre.link
        pre.link = newNode
    }

    fun insertLastNode(data: String?) {
        val newNode = ListNode(data)
        if (head == null) {
            head = newNode
        } else {
            var temp = head
            while (temp!!.link != null) temp = temp.link
            temp.link = newNode
        }
    }

    fun deleteLastNode() {
        var pre: ListNode?
        var temp: ListNode?
        if (head == null) return
        if (head!!.link == null) {
            head = null
        } else {
            pre = head
            temp = head!!.link
            while (temp!!.link != null) {
                pre = temp
                temp = temp.link
            }
            pre!!.link = null
        }
    }

    fun searchNode(data: String): ListNode? {
        var temp = head
        while (temp != null) {
            temp = if (data === temp.data) return temp else temp.link
        }
        return temp
    }

    fun reverseList() {
        var next = head
        var current: ListNode? = null
        var pre: ListNode? = null
        while (next != null) {
            pre = current
            current = next
            next = next.link
            current.link = pre
        }
        head = current
    }

    fun printList() {
        var temp = head
        println("L = (")
        while (temp != null) {
            System.out.printf(temp.data)
            temp = temp.link
            if (temp != null) {
                System.out.printf(", ")
            }
        }
        println(")")
    }

    internal inner class ListNode {
        var data: String?
            private set
        var link: ListNode?

        constructor() {
            data = null
            link = null
        }

        constructor(data: String?) {
            this.data = data
            link = null
        }

        constructor(data: String?, link: ListNode?) {
            this.data = data
            this.link = link
        }

    }

}