package leetcode.two_pointer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class TP345 {
    public String reverseVowels(String s) {

        String[] str = s.split("");
        Pattern pt = Pattern.compile("[aeiouAEIOU]");

        int p1 = 0;
        boolean find1 = false;
        int p2 = str.length - 1;
        boolean find2 = false;

        while(p1 < p2) {

            while(p1 < p2 && !pt.matcher(str[p1]).find()) {
                p1 ++;
            }

            while(p1 < p2 && !pt.matcher(str[p2]).find()) {
                p2 --;
            }

            if(p1 < p2){
                String tmp = str[p1];

                str[p1] = str[p2];
                str[p2] = tmp;
                p1 ++;
                p2 --;
            }
        }

        return String.join("", str);
    }
}
