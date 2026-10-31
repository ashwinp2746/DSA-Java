/*

LeetCode :- https://leetcode.com/problems/longest-common-prefix/submissions/2186386190/

*/

package Tries;

public class LongestCommonPrefix {

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

    public static String longestCommonPrefix(Node root){

        Node curr = root;
        
        StringBuilder ans = new StringBuilder();

        while (true) {
            int count = 0;
            int index = 0;

            for(int i=0 ; i<26; i++){
                if(curr.children[i] != null){
                    count++;
                    index = i;
                }
            }

            if(count != 1 || curr.eow){
                break;
            }

            ans.append((char)(index+'a'));

            curr = curr.children[index];
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String strs[] = {"flower","flow","flight"};

        for(int i=0 ; i<strs.length ; i++){
            insert(strs[i]);
        }

        System.out.println(longestCommonPrefix(root));
    }
}
