package leetcode.slidingWindow;

import java.util.*;

public class SW30_SubstringWithConcatenationOfAllWords {
    /*
        문자열 s와 문자열 배열 words가 주어집니다. words의 모든 문자열은 같은 길이입니다.
        **연결된 문자열(concatenated string)**은
        words의 어떤 순열(permutation)을 연결한 것과 정확히 일치하는 문자열입니다.

        예를 들어, words = ["ab","cd","ef"]라면,
        "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", "efcdab"는 모두 연결된 문자열입니다.
        "acdbef"는 words의 어떤 순열과도 일치하지 않으므로 연결된 문자열이 아닙니다.

        s에서 모든 연결된 부분 문자열의 시작 인덱스를 담은 배열을 반환하세요. 답은 어떤 순서로 반환해도 됩니다.

        words 배열안에 있는 모든 단어가 이어지는 (앞으로든 옆으로든 중간이든 역순이든) 시작 인덱스를 찾으시오
     */

    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> ans = new ArrayList<>();

        Map<String,Integer> wMap = new HashMap<>();
        for(String word : words) {
            wMap.put(word, wMap.getOrDefault(word, 0) + 1);
        }

        int wordLen = words[0].length();
        int totalLen = words.length * wordLen;
        Map<String,Integer> fMap = new HashMap<>();

        // 각 시작점에서 고정 윈도우로 체크
        for (int i = 0; i <= s.length() - totalLen; i++) {

            boolean isAdd = true;
            String substring = s.substring(i, i + totalLen);
            // substring을 wordLen 단위로 나누어 words와 비교

            for(int k = 0; k < substring.length(); k = k + wordLen) {

                String word = substring.substring(k, k + wordLen);
                if(!wMap.containsKey(word)) {
                    isAdd = false;
                    break;
                }

                if(
                        fMap.containsKey(word) &&
                                fMap.get(word) >= wMap.get(word)
                ) {

                    System.out.println(word);

                    isAdd = false;
                    break;
                }

                fMap.put(word, wMap.getOrDefault(word, 0) + 1);
            }

            if(isAdd) ans.add(i);

            fMap = new HashMap<>();

        }

        return ans;

    }

}
