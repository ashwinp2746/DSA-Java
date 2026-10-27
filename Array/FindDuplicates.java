/*
Leetcode:-https://leetcode.com/problems/find-the-duplicate-number/description/
*/

package Array;

import java.util.HashSet;

public class FindDuplicates {

    //HashSet approach
    public static int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int i=0 ; i<nums.length ; i++){
            if(set.contains(nums[i])){
                return nums[i];
            }else{
                set.add(nums[i]);
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicate(nums));
    }
}
