package leetcode.map;

import java.util.*;

public class Map2215 {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        List<Integer> list1 = new ArrayList<>(nums1.length);
        List<Integer> list2 = new ArrayList<>(nums2.length);

        for(int i = 0; i < nums1.length; i ++) {
            if(!map1.containsKey(nums1[i])){
                map1.put(nums1[i], 1);
            }
        }

        for(int i = 0; i < nums2.length; i ++) {

            if(!map2.containsKey(nums2[i])){
                map2.put(nums2[i], 1);
                if(!map1.containsKey(nums2[i])){
                    list2.add(nums2[i]);
                }
            }
        }

        for(int i = 0; i < nums1.length; i ++) {
            if(!map2.containsKey(nums1[i])){
                if(map1.get(nums1[i]) > 0) {
                    list1.add(nums1[i]);
                    map1.put(nums1[i], 0);
                };
            }
        }
        Deque<Character> s = new ArrayDeque<>();
        return List.of(
                list1, list2
        );
    }
}
