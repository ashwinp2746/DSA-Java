/*
leetcode :-https://leetcode.com/problems/implement-trie-prefix-tree/

Time Complexity:-
insert(word):-O(L)
search(word):-O(L)	
startsWith(prefix):-O(L)
*/


package Tries;

public class ImplementOfTrie {
    static class Trie {

        class Node {
            Node[] children = new Node[26];
            boolean eow = false;
        }

        public final Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node curr = root;

            for (int level = 0; level < word.length(); level++) {
                int idx = word.charAt(level) - 'a';
                if (curr.children[idx] == null) {
                    curr.children[idx] = new Node();
                }

                curr = curr.children[idx];
            }

            curr.eow = true;
        }

        public boolean search(String word) {
            Node curr = root;

            for (int level = 0; level < word.length(); level++) {
                int idx = word.charAt(level) - 'a';
                if (curr.children[idx] == null) {
                    return false;
                }

                curr = curr.children[idx];
            }

            return curr.eow;
        }

        public boolean startsWith(String prefix) {
            Node curr = root;

            for (int i = 0; i < prefix.length(); i++) {
                int idx = prefix.charAt(i) - 'a';

                if (curr.children[idx] == null) {
                    return false;
                }

                curr = curr.children[idx];
            }

            return true;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        
        trie.insert("apple");
        trie.insert("app");

        
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.search("ap")); 

        System.out.println(trie.startsWith("ap")); 
        System.out.println(trie.startsWith("ba")); 
    }
}
