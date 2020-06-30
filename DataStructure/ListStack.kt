package DataStructure

internal interface StackIF {
    val isEmpty: Boolean
    val isFull: Boolean
    fun push(data: String?)
    fun pop()
    fun peek()
    fun clear()
} // 스택을 구성하는 Node 클래스

class ListStackNode {
    var data // 데이터 저장 변수
            : String?
        private set
    var link // 다른 노드를 참조할 링크
            : ListStackNode?

    constructor() {
        data = null
        link = null
    }

    constructor(data: String?) {
        this.data = data
        link = null
    }

    constructor(data: String?, link: ListStackNode?) {
        this.data = data
        this.link = link
    }

}

class ListStack// head 초기화
// top 포인터 초기화
// 스택 사이즈 초기화
// 스택 생성자
    (// 스택 사이즈
    private val stackSize: Int
) : StackIF {
    private var head // ListStackNode 타입의 head 노드 인스턴스 변수
            : ListStackNode? = null
    private var top // 스택의 top 포인터
            : ListStackNode? = null

    // 스택이 비어있는 상태인지 확인
    override val isEmpty: Boolean
        get() = top == null// 다음 노드를 참조
    // 스택 사이즈와 노드 카운트가 동일한 경우 true return
// tempNode에 head 할당// 스택 노드 카운터// 스택 비어있을 경우 false return

    // 스택이 가득찬 상태인지 확인
    override val isFull: Boolean
        get() =// 스택 비어있을 경우 false return
            if (isEmpty) {
                false
            } else {
                var nodeCount = 0 // 스택 노드 카운터
                var tempNode = head // tempNode에 head 할당
                while (tempNode!!.link != null) {
                    ++nodeCount
                    tempNode = tempNode.link // 다음 노드를 참조
                }
                // 스택 사이즈와 노드 카운트가 동일한 경우 true return
                stackSize - 1 == nodeCount
            }

    // 스택에 Node 삽입 (마지막에 삽입)
    override fun push(data: String?) {
        val newNode = ListStackNode(data) // 새로운 노드 생성
        // 스택이 가득 찼을 경우
        if (isFull) {
            println("Stack is full!")
            return
        } else if (isEmpty) { // top 포인터가 null인 경우 새로운 노드를 참조하도록 함
// 이 떄 head도 함께 새로운 노드를 참조하도록 함 (head는 첫 노드를 참조하는 용도로만 사용을 제한)
            head = newNode
            top = head
        } else { // top 노드가 null이 아닌 경우 temp 노드가 top을 참조하도록 함.
// tempNode는 마지막 노드를 찾기 위해 사용.
            var tempNode = top
            // temp 노드의 link가 null이 아닐 때까지 다음 노드를 참조.
// tempNode.link는 다음 노드를 참조하고 있으므로,
// tempNode = tempNode.link는 tempNode가 다음 노드를 참조하도록 하는 것.
// while문이 모두 실행되면 tempNode는 가장 마지막 노드를 참조한 상태가 됨.
            while (tempNode!!.link != null) {
                tempNode = tempNode.link // 다음 노드를 참조
            }
            // tempNode(마지막 노드)의 link가 다음 노드를 참조하도록 함.
            tempNode.link = newNode
        }
    }

    // 스택에서 Node 삭제 (마지막 노드 삭제)
    override fun pop() {
        var preNode: ListStackNode?
        var tempNode: ListStackNode?
        // top 포인터가 null인 경우 모든 노드가 삭제되었으므로 return
        if (isEmpty) {
            println("Stack is empty!")
            return
        }
        // top 포인터의 link가 null인 경우 (스택의 노드가 1개 남았을 경우)
        if (top!!.link == null) { // head와 top 포인터에 null을 할당하여 남은 노드와의 연결을 끊고 초기화
            head = null
            top = null
        } else {
            preNode = top // preNode는 top 포인터가 가리키는 노드를 할당
            tempNode = top!!.link // tempNode는 top 포인터가 가리키는 노드의 다음 노드 (preNode의 다음 노드)
            // tempNode의 link가 null이 아닐 때까지 한 노드씩 다음 노드로 이동.
// preNode는 tempNode를 할당하고
// tempNode는 tempNode의 다음 노드를 할당.
// 이렇게 하면 preNode는 마지막 노드의 이전 노드가 되고, tempNode는 마지막 노드가 됨.
            while (tempNode!!.link != null) {
                preNode = tempNode
                tempNode = tempNode.link
            }
            // preNode의 link를 null로 만들어서 가장 마지막 노드를 삭제
// 즉, preNode의 다음 노드인 tempNode로의 연결을 끊음.
            preNode!!.link = null
        }
    }

    // 스택의 최상위(마지막) 데이터 추출
    override fun peek() {
        if (isEmpty) {
            println("Stack is empty!")
            return
        } else {
            var tempNode = top
            while (tempNode!!.link != null) {
                tempNode = tempNode.link
            }
            println(tempNode.data)
        }
    }

    // 스택 초기화
    override fun clear() {
        if (isEmpty) {
            println("Stack is empty!")
            return
        } else { // 스택 포인터와 head 초기화
            head = null
            top = null
        }
    }

    // 스택 Node 탐색
    fun searchNode(data: String): ListStackNode? {
        var tempNode = top // temp 노드에 top 포인터가 가리키는 노드를 할당.
        // temp 노드가 null이 아닐 때까지 반복하여 탐색
        while (tempNode != null) { // 주어진 데이터와 temp 노드의 데이터가 일치할 경우 해당 temp 노드를 return
            tempNode = if (data == tempNode.data) {
                return tempNode
            } else { // 데이터가 일치하지 않을 경우 temp 노드에 다음 노드 할당.
                tempNode.link
            }
        }
        return tempNode
    }

    // 스택에 저장된 모든 데이터를 출력
    fun printListStack() {
        if (isEmpty) {
            println("Stack is empty!")
            return
        } else {
            var tempNode = top // tempNode에 head가 가리키는 첫번째 노드를 할당
            // tempNode가 null이 아닐 때까지 반복하여 출력
            while (tempNode != null) {
                print(tempNode.data + " ")
                tempNode = tempNode.link // temp 노드에 다음 노드(tempNode.link) 할당.
            }
            println()
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val stackSize = 5
            val str = "B"
            val listStack = ListStack(stackSize) // 스택 생성
            listStack.printListStack()
            listStack.push("A")
            listStack.printListStack()
            listStack.push("B")
            listStack.printListStack()
            listStack.push("C")
            listStack.printListStack()
            listStack.push("D")
            listStack.printListStack()
            listStack.push("E")
            listStack.printListStack()
            listStack.push("F")
            listStack.printListStack()
            listStack.pop()
            listStack.printListStack()
            listStack.pop()
            listStack.printListStack()
            listStack.peek()
            println(listStack.searchNode(str)!!.data)
        }
    }

}