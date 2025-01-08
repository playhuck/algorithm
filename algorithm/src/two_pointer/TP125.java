package two_pointer;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TP125 {
    /*
        구문에서 모든 대문자를 소문자로 변환하고 모든 영숫자가 아닌 문자를 제거한 후,
        앞으로 읽으나 뒤로 읽으나 동일하다면 그것은 회문입니다. 영숫자에는 문자와 숫자가 포함됩니다.
        문자열 s가 주어질 때, 이것이 회문이면 true를, 그렇지 않으면 false를 반환하세요.

        Input: s = "A man, a plan, a canal: Panama"
        Output: true

        Input: s = "race a car"
        Output: false
     */

    public static boolean isPalindrome(String s) {

        Pattern pattern = Pattern.compile("[a-zA-Z0-9]");

        final String str = String
                .join("", Arrays.stream(s.split("")).filter(v -> {
                            Matcher matcher = pattern.matcher(v);

                            return matcher.matches();
                        })
                        .map(String::toLowerCase).toList());

        final String reverse = new StringBuilder(str).reverse().toString();

        System.out.println(str + " " + reverse);

        return str.equals(reverse);

    }
}
