package DataStructure

internal interface QueueIF {
    val isEmpty: Boolean
    val isFull: Boolean
    fun enqueue(data: String?)
    fun dequeue()
    fun peek()
    fun clear()
} // 큐를 구성하는 Node 클래스

class ListQueueNode {
    var data // 데이터 저장 변수
            : String?
        private set
    var link // 다른 노드를 참조할 링크
            : ListQueueNode?

    constructor() {
        data = null
        link = null
    }

    constructor(data: String?) {
        this.data = data
        link = null
    }

    constructor(data: String?, link: ListQueueNode?) {
        this.data = data
        this.link = link
    }

}

class ListQueue// head 초기화
// front 포인터 초기화
// rear 포인터 초기화
// 큐 사이즈 초기화
// 큐 생성자
    (// 큐 사이즈
    private val queueSize: Int
) : QueueIF {
    private var head // ListQueueNode 타입의 head 노드 인스턴스 변수
            : ListQueueNode? = null
    private var front // 큐의 front 포인터
            : ListQueueNode? = null
    private var rear // 큐의 rear 포인터
            : ListQueueNode? = null

    // 큐가 비어있는 상태인지 확인
    override val isEmpty: Boolean
        get() = front == null && rear == null// 다음 노드를 참조
    // 큐 사이즈와 노드 카운트가 동일한 경우 true return
// tempNode에 head 할당// 큐 노드 카운터// 큐 비어있을 경우 false return

    // 큐가 가득찬 상태인지 확인
    override val isFull: Boolean
        get() =// 큐 비어있을 경우 false return
            if (isEmpty) {
                false
            } else {
                var nodeCount = 0 // 큐 노드 카운터
                var tempNode = head // tempNode에 head 할당
                while (tempNode!!.link != null) {
                    ++nodeCount
                    tempNode = tempNode.link // 다음 노드를 참조
                }
                // 큐 사이즈와 노드 카운트가 동일한 경우 true return
                queueSize - 1 == nodeCount
            }

    // 큐에 Node 삽입
    override fun enqueue(data: String?) {
        val newNode = ListQueueNode(data) // 새로운 노드 생성
        // 큐가 가득 찼을 경우
        if (isFull) {
            println("Queue is full!")
            return
        } else if (isEmpty) { // front,rear 포인터가 null인 경우 새로운 노드를 참조하도록 함
// 이 때 head도 함께 새로운 노드를 참조하도록 함 (head는 첫 노드를 참조하는 용도로만 사용을 제한)
            head = newNode
            front = head
            rear = head
        } else { // rear 포인터의 노드(마지막 노드) link가 새로운 노드를 참조하도록 함.
// 이후 rear 포인터는 새로 추가된 노드를 참조하도록 함.
            rear!!.link = newNode
            rear = newNode
        }
    }

    // 큐에서 Node 삭제
    override fun dequeue() {
        val tempNode: ListQueueNode?
        // front 포인터가 null인 경우 모든 노드가 삭제되었으므로 return
        if (isEmpty) {
            println("Queue is empty!")
            return
        }
        // front 포인터의 link가 null인 경우 (큐에 노드가 1개 남았을 경우)
        if (front!!.link == null) { // head와 front,rear 포인터에 null을 할당하여 남은 노드와의 연결을 끊고 초기화
            head = null
            front = null
            rear = null
        } else {
            tempNode = front!!.link // tempNode는 front 포인터가 가리키는 노드의 다음 노드를 할당.
            head = tempNode // head가 tempNode를 참조하도록 함
            front!!.link = null // 기존에 front 포인터가 가리키는 노드의 link를 초기화하여 끊음
            front = head // front 포인터가 head(다음 노드)를 참조하도록 함
        }
    }

    // 큐의 첫번째 데이터 추출
    override fun peek() {
        if (isEmpty) {
            println("Queue is empty!")
            return
        } else {
            println(front!!.data)
        }
    }

    // 큐 초기화
    override fun clear() {
        if (isEmpty) {
            println("Queue is empty!")
            return
        } else { // 큐의  head와 front,rear포인터 초기화
            head = null
            front = null
            rear = null
        }
    }

    // 큐 Node 탐색
    fun searchNode(data: String): ListQueueNode? {
        var tempNode = front // temp 노드에 front 포인터가 가리키는 노드를 할당.
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

    // 큐에 저장된 모든 데이터를 출력
    fun printListQueue() {
        if (isEmpty) {
            println("Queue is empty!")
            return
        } else {
            var tempNode = front // tempNode에 head가 가리키는 첫번째 노드를 할당
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
            val queueSize = 5
            val str = "D"
            val listQueue = ListQueue(queueSize) // 큐 생성
            listQueue.printListQueue()
            listQueue.enqueue("A")
            listQueue.printListQueue()
            listQueue.enqueue("B")
            listQueue.printListQueue()
            listQueue.enqueue("C")
            listQueue.printListQueue()
            listQueue.enqueue("D")
            listQueue.printListQueue()
            listQueue.enqueue("E")
            listQueue.printListQueue()
            listQueue.enqueue("F")
            listQueue.printListQueue()
            listQueue.dequeue()
            listQueue.printListQueue()
            listQueue.dequeue()
            listQueue.printListQueue()
            listQueue.peek()
            println(listQueue.searchNode(str)!!.data)
        }
    }

}