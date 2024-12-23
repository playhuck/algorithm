package sort;

import java.util.*;

public class Sort1005_MaximizeSumOfArrayAfterKNegations {
    /*
        정수 배열 nums와 정수 k가 주어질 때, 다음과 같은 방식으로 배열을 수정하세요:

        인덱스 i를 선택하여 nums[i]를 -nums[i]로 교체합니다.
        이 과정을 정확히 k번 적용해야 합니다. 같은 인덱스 i를 여러 번 선택할 수 있습니다.
        이러한 방식으로 배열을 수정한 후 가능한 가장 큰 배열의 합을 반환하세요.

        음수만 먼저 k로 소모,

        k가 모자를 수도 있으니, 음수 크기 정렬

        음수를 다 정렬하고 만약 k가 남았다면, 음수를 배열에 반영 후 배열에서 가장 작은 값을 minus 처리

     */

    public static int largestSumAfterKNegations(int[] nums, int k) {

        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());

        List<Integer> list = new ArrayList<>();

        for (int j : nums) {

            if (j <= 0) {
                list.add(j);
            } else {
                maxQueue.add(j);
            }
        }

        Collections.sort(list);

        int count = k;

        for (int num : list) {

            if (count > 0) {
                maxQueue.add(Math.abs(num));
                count--;
            } else {
                maxQueue.add(num);
            }
        }

        int val = 0;

        while (maxQueue.size() > 1) {

            System.out.println(maxQueue.peek());

            val += maxQueue.poll();

        }

        int last = maxQueue.poll();

        while (count > 0) {

            last = last * -1;
            count --;
        }

        return val + last;
    }
}
