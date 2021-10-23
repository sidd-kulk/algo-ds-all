package basics.problems.simple

/// wip
class Trie<String>(val rootNodes: List<Node<String>>) {
    fun search(t: String) {
        // PENDING
    }
}

class Node<String>(val value: String, val children: List<Node<String>>, val isCompleteWord: Boolean) {
    override fun equals(other: Any?): Boolean {
        return value?.equals(other) ?: false
    }

    override fun hashCode(): Int {
        return value?.hashCode() ?: 0
    }
}