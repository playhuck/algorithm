package leetcode.two_pointer;

import java.util.regex.Pattern;

public class TP392 {
    public boolean isSubsequence(String s, String t) {

        int p1 = 0;
        int p2 = 0;

        while(p1 < s.length() && p2 < t.length()) {
            if(s.charAt(p1) == t.charAt(p2)) {
                p1 ++;
            }
            p2 ++;
        }

        return p1 == s.length();
    }

    /*
        두 문자열 s와 t가 주어질 때, s가 t의 부분수열이면 true를, 그렇지 않으면 false를 반환하세요.
        문자열의 부분수열은 원래 문자열에서 일부 문자를 삭제하되(아무것도 삭제하지 않을 수도 있음)
        나머지 문자들의 상대적 위치를 방해하지 않고 형성된 새로운 문字열입니다. (즉, "ace"는 "abcde"의 부분수열이지만 "aec"는 아닙니다).
        Input: s = "abc", t = "ahbgdc"
        Output: true

        Input: s = "axc", t = "ahbgdc"
        Output: false
     */
    public boolean isSubsequence2(String s, String t) {

        int p1 = 0;
        int p2 = 0;

        while(p1 < s.length() && p2 < t.length()) {

            if(s.charAt(p1) == t.charAt(p2)) {
                p1 ++;
                p2 ++;
            } else {
                p2 ++;
            }
        }

        return p1 > p2 ? false : p1 == s.length() ? true : false;

    }
}
