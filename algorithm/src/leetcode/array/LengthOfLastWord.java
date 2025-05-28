package leetcode.array;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {

        if(s.length() == 1) return 1;

        String[] strings = s.split(" ");

        return strings[strings.length - 1].length();
    }
}
