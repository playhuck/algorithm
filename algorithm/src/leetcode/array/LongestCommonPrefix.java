package leetcode.array;

import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {

        if(strs.length <= 1) return "";

        Arrays.sort(strs);

        String fir = strs[0];
        String last = strs[strs.length-1];
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < Math.min(fir.length(), last.length()); i++) {
            if(fir.charAt(i) != last.charAt(i)) {
                return sb.toString();
            }
            sb.append(fir.charAt(i));
        }

        return sb.toString();

    }
}
