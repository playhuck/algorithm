package math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class 이진수 {

    class Solution {
        public String solution(String bin1, String bin2) {
            String answer = "";

            if(Objects.equals(bin1, "0") && Objects.equals(bin2, "0")){
                return  "0";
            }

            String[] ns = bin1.split("");
            int n = 0;
            for (int i = 0; i < ns.length; i++) {

                int v = Integer.parseInt(ns[i]) * (int) Math.pow(2, ns.length - i - 1) > 0 ? (int) Math.pow(2, ns.length - i - 1) : 0;

                n = n + v;
            }

            int n2 = 0;
            String[] ns2 = bin2.split("");
            for (int i = 0; i < ns2.length; i++) {

                int v = Integer.parseInt(ns2[i]) * (int) Math.pow(2, ns2.length - i - 1) > 0 ? (int) Math.pow(2, ns2.length - i - 1) : 0;

                n2 = n2 + v;
            }

            int sum = n + n2;

            while (sum > 0) {

                if(sum % 2 == 1) {
                    answer += "1";
                    sum = sum / 2;
                } else {
                    answer += "0";
                    sum = sum / 2;
                }
            }

            List<String> strings = new ArrayList<>(List.of(answer.split("")));
            Collections.reverse(strings);

            return String.join("", strings);
        }
    }

}
