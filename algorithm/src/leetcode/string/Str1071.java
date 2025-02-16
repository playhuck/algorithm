package leetcode.string;

public class Str1071 {

    public String gcdOfStrings(String str1, String str2) {

        if(!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        int len1 = str1.length();
        int len2 = str2.length();

        int max = Math.max(len1, len2);
        int min = Math.min(len1, len2);

        int gcd = 0;

        while(min > 1) {

            int rest = max % min;

            if(rest == 0) {
                gcd = rest;
                break;
            } else {

                max = min;
                min = rest;
            }

        }

        if(gcd == 0) {
            gcd = min;
        }

        return str1.substring(0, gcd);

    }


}
