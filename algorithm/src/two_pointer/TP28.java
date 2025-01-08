package two_pointer;

public class TP28 {
    /*
        문자열 needle과 haystack이 주어질 때,
        haystack 안에서 needle이 처음 등장하는 인덱스를 반환하세요.
        만약 needle이 haystack의 일부가 아니라면 -1을 반환하세요.
        Input: haystack = "sadbutsad", needle = "sad"
        Output: 0
     */

    public static int strStr(String haystack, String needle) {

        if(haystack.contains(needle)){

            int n = haystack.indexOf(needle);

            return n;
        } else {
            return -1;
        }

    }
}
