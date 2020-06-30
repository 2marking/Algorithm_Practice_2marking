package DataStructure

/*
 * @ TITLE Stack (배열로 구현한 스택)
 */
internal interface Stack {
    val isEmpty: Boolean
    val isFull: Boolean
    fun push(item: Char)
    fun pop(): Char
    fun peek(): Char
    fun clear()
}

class ArrayStack(stackSize: Int) : Stack {
    private var top: Int
    private val stackSize: Int
    private var stackArr: CharArray// 스택 포인터가 -1인 경우 데이터가 없는 상태이므로 true 아닌 경우 false를 return
    // 스택이 비어있는 상태인지 확인
    override val isEmpty: Boolean
        get() =// 스택 포인터가 -1인 경우 데이터가 없는 상태이므로 true 아닌 경우 false를 return
            top == -1// 스택 포인터가 스택의 마지막 인덱스와 동일한 경우 true 아닌 경우 false를 return

    // 스택이 가득찬 상태인지 확인
    override val isFull: Boolean
        get() =// 스택 포인터가 스택의 마지막 인덱스와 동일한 경우 true 아닌 경우 false를 return
            top == stackSize - 1

    // 스택에 데이터를 추가
    override fun push(item: Char) {
        if (isFull) {
            println("Stack is full!")
        } else {
            stackArr[++top] = item // 다음 스택 포인터가 가리키는 인덱스에 데이터 추가
            println("Inserted Item : $item")
        }
    }

    // 스택의 최상위(마지막) 데이터 추출 후 삭제
    override fun pop(): Char {
        return if (isEmpty) {
            println("Deleting fail! Stack is empty!")
            '0'
        } else {
            println("Deleted Item : " + stackArr[top])
            stackArr[--top]
        }
    }

    // 스택의 최상위(마지막) 데이터 추출
    override fun peek(): Char {
        return if (isEmpty) {
            println("Peeking fail! Stack is empty!")
            '0'
        } else {
            println("Peeked Item : " + stackArr[top])
            stackArr[top]
        }
    }

    // 스택 초기화
    override fun clear() {
        if (isEmpty) {
            println("Stack is already empty!")
        } else {
            top = -1 // 스택 포인터 초기화
            stackArr = CharArray(stackSize) // 새로운 스택 배열 생성
            println("Stack is clear!")
        }
    }

    // 스택에 저장된 모든 데이터를 출력
    fun printStack() {
        if (isEmpty) {
            println("Stack is empty!")
        } else {
            print("Stack elements : ")
            for (i in 0..top) {
                print(stackArr[i].toString() + " ")
            }
            println()
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val stackSize = 5
            val arrStack = ArrayStack(stackSize)
            arrStack.push('A')
            arrStack.printStack()
            arrStack.push('B')
            arrStack.printStack()
            arrStack.push('C')
            arrStack.printStack()
            arrStack.pop()
            arrStack.printStack()
            arrStack.pop()
            arrStack.printStack()
            arrStack.peek()
            arrStack.printStack()
            arrStack.clear()
            arrStack.printStack()
        }
    }

    // 스택을 생성하는 생성자
    init {
        top = -1 // 스택 포인터 초기화
        this.stackSize = stackSize // 스택 사이즈 설정
        stackArr = CharArray(this.stackSize) // 스택 배열 생성
    }
}