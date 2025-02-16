package leetcode.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class 버블정렬 {

    static class Solution {
        public int[] solution(String my_string) {

            List<Integer> integers = new ArrayList<>();
            Pattern pattern = Pattern.compile("[0-9]");

            for (String s : my_string.split("")) {

                if(pattern.matcher(s).matches()) {
                    integers.add(Integer.parseInt(s));
                }
            }

            if(integers.isEmpty()) return new int[]{};

            int[] answer = new int[integers.size()];

            boolean swap;

            for (int i = 0; i < integers.size(); i++) {

                answer[i] = integers.get(i);

            }

            for (int i = 0; i < answer.length - 1; i++) {

                swap = false;

                for (int j = 0; j < answer.length - 1 - i; j++) {

                    if(answer[j] == answer[j + 1]) continue;

                    if(answer[j] >  answer[j + 1]) {

                        int temp = answer[j];
                        answer[j] = answer[j + 1];
                        answer[j + 1] = temp;

                        swap = true;
                    }

                }

                if(!swap) break;
            }

            return answer;
        }
    }

}
