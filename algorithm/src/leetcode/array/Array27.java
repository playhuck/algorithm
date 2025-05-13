package leetcode.array;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*
    Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
    The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

    Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:

    Change the array nums such that the first k elements of nums contain the elements which are not equal to val.
    The remaining elements of nums are not important as well as the size of nums.
    Return k.
 */
public class Array27 {

    class Solution {
        public int[] removeElement(int[] nums, int val) {

            List<Integer> list = new ArrayList<>();

            for(int i : nums) {

                if(i != val) {
                    list.add(i);
                }
            }

            return list.stream().mapToInt(i -> i).toArray();

        }
    }

}
