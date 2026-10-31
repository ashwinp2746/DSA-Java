/*

GFG : https://www.geeksforgeeks.org/problems/print-anagrams-together/1

*/

package Hashing;

import java.util.*;

public class GroupAnagramTogether {

    public static HashMap<String , List<String>> map = new HashMap<>();
    
    public static List<List<String>> groupAnagram(String strs[]){
        for(String str : strs){
            char[] ch = str.toCharArray();

            Arrays.sort(ch);

            String sorted = new String(ch);

            if(!map.containsKey(sorted)){
                map.put(sorted , new ArrayList<>());
            }

            map.get(sorted).add(str);
        }

        return new ArrayList<>(map.values());
    }
    
    public static void main(String[] args) {
        String strs[] = {"eat" , "tea" , "tan" , "ate" , "nat" , "bat"};

        System.out.println(groupAnagram(strs));
        
    }
}
