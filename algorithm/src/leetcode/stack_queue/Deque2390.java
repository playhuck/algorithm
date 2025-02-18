package leetcode.stack_queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Deque2390 {

    public String removeStars(String s) {

        List<String> list = new ArrayList<>(s.length());
        String[] strings = s.split("");

        for(int i = 0; i < s.length(); i ++) {

            if(strings[i].equals("*")) {

                if(list.size() > 0) {
                    list.remove(list.size() - 1);
                }
            } else {

                list.add(strings[i]);
            }
        }

        return String.join("", list);

    }

    public String removeStars2(String s) {

        StringBuilder str = new StringBuilder();

        for(int i = 0; i < s.length(); i ++) {

            if(s.charAt(i) == '*') {
                str.deleteCharAt(str.length() - 1);
            } else {
                str.append(s.charAt(i));
            }
        }

        return str.toString();

    }
}
