package leetcode.bruteforce;

public class BF3184 {
    /*
        시간 단위로 표현된 정수 배열 hours가 주어집니다. i < j 조건을 만족하는 쌍 i, j에 대해, hours[i] + hours[j]가 완전한 하루를 이루는 쌍의 개수를 반환하세요.
        여기서 완전한 하루란 정확히 24시간의 배수가 되는 시간을 의미합니다.
        예를 들어, 1일은 24시간, 2일은 48시간, 3일은 72시간 등이 됩니다.
     */
    public static int countCompleteDayPairs(int[] hours) {

        int count = 0;

        for (int i = 0; i < hours.length; i++) {

            for (int j = i + 1; j < hours.length; j++) {

                int hour = hours[i] + hours[j];
                if(hour % 24 == 0) {
                    count ++;
                }

            }
        }

        return count;
    }
}
