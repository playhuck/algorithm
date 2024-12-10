package bruteforce;

import java.util.HashMap;
import java.util.Map;

public class BF1160 {
    /*
        chars를 조합하여 countCharacters의 값들을 만들 수 있다면 그 값들만큼 String length ++
     */
    public static int countCharacters(String[] words, String chars) {

        int answer = 0;

        for (String word : words) {

            String[] split = word.split("");

            Map<Character, Integer> map = new HashMap<>();

            int contained = 0;

            for(String s : split) {

                char targetChar = s.charAt(0);
                if(map.containsKey(targetChar)) {
                    continue;
                } else {
                    map.put(targetChar, 1);
                }
                long wordCount = word.chars().filter(c -> c == targetChar).count();
                long charsCount = chars.chars().filter(c -> c == targetChar).count();

                if(wordCount <= charsCount) {
                    contained = contained + (int) wordCount;
                }

            }

            if(contained == split.length) {
                System.out.println("is Added" + word);
                answer += split.length;
            }

        }

        return answer;
    }
}
