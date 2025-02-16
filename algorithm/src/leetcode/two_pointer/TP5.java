package leetcode.two_pointer;

import java.util.ArrayDeque;
import java.util.Deque;

public class TP5 {
    /*
        문자열 `s`가 주어질 때, `s`에서 *가장 긴 회문 부분 문자열*을 반환하세요.

        Input: s = "babad"
        Output: "bab"

     */

    public static String longestPalindrome(String s) {

        String max = "";

        String[] strings = s.split("");

        for (int i = 0; i < strings.length; i++) {

            String str = strings[i];
            if(max.isBlank()) {
                max = str;
            }
            int aLeft = i - 1;
            int aRight = i + 1;

            Deque<String> aDeque = new ArrayDeque<>();
            aDeque.addLast(str);

            /*
                짝수 팰린드럼
             */
            if(aRight < strings.length && strings[aRight].equals(str)) {
                aDeque.addLast(strings[aRight]);
                aRight ++;
                while (aLeft >= 0 && aRight < strings.length) {

                    String str1 = strings[aLeft];
                    String str2 = strings[aRight];
                    if(str1.equals(str2)) {
                        aDeque.addFirst(str1);
                        aDeque.addLast(str2);
                        aLeft--;
                        aRight++;
                    } else {
                        break;
                    }
                }
                if(String.join("", aDeque).length() > max.length()) {
                    max = String.join("", aDeque);
                }
            }
            /*
                홀수 팰린드럼
             */
            Deque<String> bDeque = new ArrayDeque<>();
            bDeque.addLast(str);

            int bLeft = i - 1;
            int bRight = i + 1;
            if(bLeft >= 0 && bRight < strings.length && strings[bLeft].equals(strings[bRight])) {

                while (bLeft >= 0 && bRight < strings.length) {
                    String str1 = strings[bLeft];
                    String str2 = strings[bRight];
                    if(str1.equals(str2)) {
                        bDeque.addFirst(str1);
                        bDeque.addLast(str2);
                        bLeft--;
                        bRight++;
                    } else {
                        break;
                    }
                }
                if(String.join("", bDeque).length() > max.length()) {
                    max = String.join("", bDeque);
                }
            }
        }

        return max;
    }
}
