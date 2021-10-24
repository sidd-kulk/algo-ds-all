package basics.problems.simple


class Node<T>(var data: T?, var next: Node<T>?) {
    fun hasNext(): Boolean {
        return next != null
    }
}

class LinkedList<T> {
    private var rootNode: Node<T>? = null

    fun add(t: T) {
        if(rootNode == null){
            rootNode = Node(t, null)
        } else {

            val newNode = Node(t, null)
            var tempNode = rootNode
            while(tempNode?.hasNext() == true){
                tempNode = tempNode.next!!
            }
            tempNode?.next = newNode
        }
    }
}