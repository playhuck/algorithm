package leetcode.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Map1657 {
    public boolean closeStrings(String word1, String word2) {

        if(word1.length() != word2.length()) {
            return false;
        }

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for(int i = 0; i < word1.length(); i ++) {

            map1.put(word1.charAt(i), map1.getOrDefault(word1.charAt(i), 0) + 1);
        }

        for(int i = 0; i < word2.length(); i ++) {

            map2.put(word2.charAt(i), map2.getOrDefault(word2.charAt(i), 0) + 1);
        }

        if(map1.size() != map2.size()) {
            return false;
        }

        PriorityQueue<Integer> que1 = new PriorityQueue<>();
        PriorityQueue<Integer> que2 = new PriorityQueue<>();

        for(Map.Entry<Character, Integer> entry : map1.entrySet()) {

            char key = entry.getKey();

            if(!map2.containsKey(key)) {
                return false;
            }

            que1.add(map1.get(key));
            que2.add(map2.get(key));

        }

        while(!que1.isEmpty()) {

            int q1 = que1.poll();
            int q2 = que2.poll();

            if(q1 != q2) {
                return false;
            }
        }

        return true;

    }

    public boolean closeStrings2(String word1, String word2) {

        int[] f1 = new int[26];
        int[] f2 = new int[26];

        for( char c : word1.toCharArray()) {
            f1[c - 'a'] ++;
        }

        for( char c : word2.toCharArray()) {
            f2[c - 'a' ] ++;
        }

        for(int i = 0; i < 26; i ++) {

            if((f1[i] == 0 && f2[i] != 0) || (f1[i] != 0 && f2[i] == 0)) {
                return false;
            }
        }

        Arrays.sort(f1);
        Arrays.sort(f2);

        for(int i = 0; i < 26; i ++) {

            if(f1[i] != f2[i]) {
                return false;
            }
        }

        return true;
    }
}
