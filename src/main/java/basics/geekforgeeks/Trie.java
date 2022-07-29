package basics.geekforgeeks;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Trie {
    private TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode current = this.root;
        for (Character c : word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                current.children.put(c, new TrieNode());
            }
            current = current.children.get(c);
        }
        current.isEndOfWord = true;
    }

    boolean search(String word) {
        return search(word, false);
    }

    boolean prefixSearch(String prefix) {
        return search(prefix, true);
    }

    private boolean search(String word, boolean isPrefix) {
        TrieNode current = this.root;
        for (Character c : word.toCharArray()) {
            if (current.children.containsKey(c)) {
                current = current.children.get(c);
                if (!isPrefix && current.isEndOfWord) return true;
            } else {
                return false;
            }
        }
        return isPrefix;
    }

    private class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndOfWord;

        TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }

    public static void main(String[] args) {
        testBasicTrie();
    }

    static void testBasicTrie() {
        Trie trie = new Trie();
        trie.insert("app");
        assertTrue(trie.search("app"));
        assertFalse(trie.prefixSearch("aps"));
        assertTrue(trie.prefixSearch("ap"));
        assertFalse(trie.search("bat"));

        trie.insert("bat");
        assertTrue(trie.search("bat"));
        assertTrue(trie.prefixSearch("ba"));
        assertFalse(trie.prefixSearch("boink"));
    }
}