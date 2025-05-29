package leetcode.array;

import java.util.*;

public class TextJustification {

    /*
        주어진 단어를 기준으로 최대치로 채워야 한다. 만약 최대치로 채우지 못할 경우 공백으로 길이 맥스치를 채운다.
        1. 모든 줄에 단어가 한개 이상 들어가야 한다.
        2. 모든 줄은 maxWidth만큼 채워야 한다.
        3. 공백은 균등하게 분배하되, 균등할 수 없다면 왼쪽부터 채운다.

        Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
        Output:
        [
           "This    is    an",
           "example  of text",
           "justification.  "
        ]

        [
           "This is an example",
           "example  of text",
           "justification.  "
        ]

     */

    public List<String> fullJustify(String[] words, int maxWidth) {

    }

    public List<String> fullJustify2(String[] words, int maxWidth) {

        List<String> ans = new ArrayList<>();
        List<List<String>> list = new ArrayList<>();
        Map<Integer, Integer> lenMap = new HashMap<>();

        StringBuilder s = new StringBuilder();

        List<String> subList = new ArrayList<>();

        // 1. 각 줄에 배치할 단어 선정
        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            if (s.length() <= maxWidth) {
                s.append(word);
                subList.add(word);
                s.append(" ");
            } else {
                list.add(subList);
                lenMap.put(list.size(), s.length());
                System.out.println(Arrays.toString(subList.toArray()));
                subList.clear();
                subList.add(word);
                s.setLength(0);
                s.append(word);

                if(i == words.length - 1){
                    list.add(subList);
                }
            }
        }
        // 2. 각 줄에 공백 배치, 전체 String을 계산한 값을 기준으로 반으로 나뉘면 반 반 할당 반으로 안나뉘면
        for(int x = 0; x < list.size(); x++){

            int len = lenMap.get(x + 1);
            List<String> sub = list.get(x);
            if(len == maxWidth) ans.add(sub.get(sub.size() - 1));
            else {
                if(sub.size() == 1) { // 하나만 있다면

                    while(sub.size() < maxWidth) {
                        sub.add(" ");
                    }
                } else {

                    int fir = len % 2 == 0 ? maxWidth - len / 2 : Math.round((float) (maxWidth - len) / 2);
                    int sec = len % 2 == 0 ? maxWidth - len / 2 : (int) Math.floor((float) (maxWidth - len) / 2);

                    System.out.println(fir + " " + len);

                    StringBuilder s2 = new StringBuilder();

                    for(int i = 0; i < sub.size(); i++){

                        s2.append(sub.get(i));

                        if(i == 0 || i == 2) {
                            String[] array = new String[fir];
                            Arrays.fill(array, " ");
                            String joinBlank = String.join("", array);
                            s2.append(joinBlank);
                        } else {
                            String[] array = new String[sec];
                            Arrays.fill(array, " ");
                            String joinBlank = String.join("", array);
                            s2.append(joinBlank);
                        }

                    }

                    ans.add(s2.toString());
                }
            }
        }

        return ans;

    }

}
