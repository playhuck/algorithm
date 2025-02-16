package leetcode.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Str151 {
    public String reverseWords(String s) {

        List<String> list = new ArrayList<>();

        for(String str : s.split(" ")) {
            list.add(str);
        }

        List<String> list2 = new ArrayList<>(list
                .stream()
                .filter(val -> !val.isEmpty())
                .toList());

        Collections.reverse(list2);

        String result = "";

        for(int i = 0; i < list2.size(); i ++) {

            if(i == list2.size() - 1) {
                result += list2.get(i);
            } else {
                result += list2.get(i) + " ";
            }
        }

        return result;

    }
}
