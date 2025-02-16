package leetcode.two_pointer;

public class TP1768 {

    public String mergeAlternately(String word1, String word2) {

        String[] words1 = word1.split("");
        String[] words2 = word2.split("");

        String result = "";

        int p1 = 0;
        int p2 = 0;

        while(p1 < words1.length || p2 < words2.length) {

            if(p1 < words1.length) {
                result += words1[p1];
                p1 ++;
            }

            if(p2 < words2.length) {
                result += words2[p2];
                p2 ++;
            }
        }

        return result;
    }

    public String mergeAlternately2(String word1, String word2) {

        String result = "";

        int i = 0;

        while(i < word1.length() || i < word2.length()) {

            if(i < word1.length()) {
                result += word1.charAt(i);
            }

            if(i < word2.length()) {
                result += word2.charAt(i);
            }

            i++;
        }

        return result;
    }
}
