package leetcode.map;

import java.util.*;

public class Map49_GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs) {

            String[] splitStr = s.split("");
            Arrays.sort(splitStr);

            String newStr = String.join("", splitStr);

            if(map.containsKey(newStr)) {

                map.get(newStr).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(newStr, list);
            }

        }

        return new ArrayList<>(map.values());

    }

    public List<List<String>> groupAnagrams2(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs) {

            char[] splitStr = s.toCharArray();
            Arrays.sort(splitStr);

            String newStr = new String(splitStr);

            if(map.containsKey(newStr)) {

                map.get(newStr).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(newStr, list);
            }

        }

        return new ArrayList<>(map.values());

    }

}
