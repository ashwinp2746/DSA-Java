package Tries;

import java.util.*;

public class GroupAnagramTogether {

    static class Node{
        Node[] children = new Node[26];
        boolean eow = false;
        ArrayList<String> words= new ArrayList<>();
    }

    public static Node root = new Node();

    public static void insert(String sorted , String str){
        Node curr = root;

        for(int i=0 ; i<sorted.length() ; i++){
            int idx = sorted.charAt(i) - 'a';

            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }   

            curr = curr.children[idx];
        }

        curr.eow = true;

        curr.words.add(str);
    }

    public static void ansArray(Node root , List<List<String>> ans){
        if(root == null){
            return;
        }

        if(root.eow == true){
            ans.add(root.words);
        }

        for(int i=0 ; i<26 ; i++){
            if(root.children[i] != null){
                ansArray(root.children[i], ans);
            }
        }
    }

    public static List<List<String>> groupAnagram(String strs[]){
        for(String str : strs){
            char[] ch = str.toCharArray();

            Arrays.sort(ch);

            String sorted = new String(ch);

            insert(sorted , str);
        }

        List<List<String>> ans = new ArrayList<>();

        ansArray(root,ans);

        return ans;
    }

    public static void main(String[] args) {
        String strs[] = { "eat", "tea", "tan", "ate", "nat", "bat" };

        System.out.println(groupAnagram(strs));
    }
}
