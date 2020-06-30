
import DataStructure.LinkedList.ListNode


fun isPalindrome(head: ListNode?): Boolean {
    if (head == null) return true
    var p: ListNode = head
    var prev = ListNode(head.`val`)
    while (p.next != null) {
        val temp = ListNode(p.next.`val`)
        temp.next = prev
        prev = temp
        p = p.next
    }
    var p1 = head
    var p2: ListNode = prev
    while (p1 != null) {
        if (p1.`val` !== p2.`val`) return false
        p1 = p1.next
        p2 = p2.next
    }
    return true
}