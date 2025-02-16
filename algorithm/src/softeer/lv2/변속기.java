package softeer.lv2;

import java.util.Scanner;

public class 변속기 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();

        String[] splits = line.split(" ");

        int[] orders = new int[8];

        for(int i =0; i < splits.length; i ++) {
            orders[i] = Integer.parseInt(splits[i]);
        }

        int start = orders[0];
        String condition = start == 1 ? "a" : start == 8 ? "d" : "m";
        String result = condition.equals("a") ? "ascending" : "descending";

        for(int n : orders) {

            if(condition.equals("a")) {

                if(start != n) {

                    result = "mixed";
                    break;
                } else {

                    start ++;
                }
            } else if(condition.equals("d")) {

                if(start != n) {

                    result = "mixed";
                    break;
                } else {

                    start --;
                }
            } else {

                result = "mixed";
                break;
            }
        }

        System.out.println(result);

    }
}
