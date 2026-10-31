/*

GeekForGeek :- https://www.geeksforgeeks.org/problems/longest-valid-word-with-all-prefixes/1

*/

package Tries;

public class LongestWordWithAllPrefix {
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;

        Node() {
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {

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

    public static String finalAns = "";

    public static void longestWord(Node root, StringBuilder temp) {
        if (root == null)
            return;

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].eow == true) {
                temp.append((char) (i + 'a'));
                if (temp.length() > finalAns.length()) {
                    finalAns = temp.toString();
                }
                longestWord(root.children[i], temp);
                // backtrack
                temp.deleteCharAt(temp.length() - 1);
            }
        }

    }

    public static void main(String[] args) {
        String words[] = { "a", "banana", "app", "appl", "ap", "apply", "apple" };

        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        longestWord(root, new StringBuilder());
        System.out.println(finalAns);
    }
}
