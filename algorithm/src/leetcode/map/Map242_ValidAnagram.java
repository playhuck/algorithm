package leetcode.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Map242_ValidAnagram {

    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false;

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for(int x = 0; x < s.length(); x++){

            char c1 = s.charAt(x);
            sMap.put(c1, sMap.getOrDefault(c1, 0) + 1);

            char c2 = t.charAt(x);
            tMap.put(c2, tMap.getOrDefault(c2, 0) + 1);
        }

        if(sMap.size() != tMap.size()) return false;

        for(Map.Entry<Character, Integer> entry : sMap.entrySet()) {

            char sKey = entry.getKey();
            int sVal = entry.getValue();

            if(!tMap.containsKey(sKey)) return false;

            if(tMap.get(sKey) != sVal) return false;
        }

        return true;

    }

    public boolean isAnagram2(String s, String t) {

        if(s.length() != t.length()) return false;

        String[] sArr = s.split("");
        Arrays.sort(sArr);

        String[] tArr = t.split("");
        Arrays.sort(tArr);

        for(int x = 0; x < s.length(); x++){

            String s1 = sArr[x];
            String t1 = tArr[x];

            if(s1.equals(t1)) return false;
        }

        return true;

    }

    public boolean isAnagram3(String s, String t) {

        char[] sArr = s.toCharArray();
        Arrays.sort(sArr);

        char[] tArr = t.toCharArray();
        Arrays.sort(tArr);

        String newS = new String(sArr);
        String newT = new String(tArr);

        return newS.equals(newT);

    }

    public boolean isAnagram4(String s, String t) {

        if(s.length()!=t.length()){
            return false;
        }

        int[] arr = new int[26];

        for(int x = 0; x < s.length(); x++){

            arr[s.charAt(x) - 'a'] ++;
        }

        for(int x = 0; x < s.length(); x++){

            arr[t.charAt(x) - 'a'] --;
        }

        for(int n : arr) {
            if(n != 0) return false;
        }

        return true;

    }


}
