package softeer.lv2;

import java.util.*;

public class GPT식숫자비교 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int bagWeight = sc.nextInt();
        int category = sc.nextInt();

        List<List<Integer>> lists = new ArrayList<>();

        for(int i =0; i < category; i ++) {

            List<Integer> subList = new ArrayList<>();

            subList.add(sc.nextInt());
            subList.add(sc.nextInt());

            lists.add(subList);
        }

        lists.sort((list1, list2) -> {
            int product1 = list1.get(0) * list1.get(1);  // 첫 번째 리스트의 두 값의 곱
            int product2 = list2.get(0) * list2.get(1);  // 두 번째 리스트의 두 값의 곱
            return product2 - product1;  // 내림차순 정렬
        });

        int cal = bagWeight;
        int result = 0;
        // 무게당 가격이 가장 높은 항목 순대로 정렬

        for(int i = 0; i < lists.size(); i++) {
            int w = lists.get(i).get(0);
            int c = lists.get(i).get(1);
            if(cal > w) {
                cal = cal - w;
                result = result + (w * c);
                lists.remove(i);
            }
        }

        for (List<Integer> list : lists) {
            int w = list.get(0);
            int c = list.get(1);
            if (cal > 0) {
                if (cal - w > 0) {
                    cal = cal - w;
                    result = result + (w * c);
                } else {

                    int minus = cal - w;

                    result = result + ((w * c) - (Math.abs(minus * c)));

                    break;
                }
            }
        }

        System.out.println(result);
    }

}
