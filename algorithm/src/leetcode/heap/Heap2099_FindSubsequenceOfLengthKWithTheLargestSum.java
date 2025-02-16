package leetcode.heap;

import java.util.*;

public class Heap2099_FindSubsequenceOfLengthKWithTheLargestSum {
    /*
        정수 배열 nums와 정수 k가 주어집니다.
        당신은 nums에서 길이가 k이고 가장 큰 합을 가지는 부분수열을 찾고자 합니다.
        길이가 k인 그러한 부분수열을 정수 배열로 반환하세요.
        어떤 부분수열이든 상관없습니다.
        부분수열은 다른 배열에서 일부 또는 아무 원소도 삭제하지 않고 남은 원소들의 순서를 변경하지 않고 만들 수 있는 배열입니다.

        Input: nums = [2,1,3,3], k = 2
        Output: [3,3]
     */

    public static int[] maxSubsequence(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, List<Integer>> map = new HashMap<>();

        final int numsLength = nums.length;
        for (int i = 0; i < numsLength; i++) {
            Integer num = nums[i];
            pq.add(num);
            if(map.containsKey(num)) {
                List<Integer> list = map.get(num);
                list.add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(num, list);
            }
        }

        if(pq.isEmpty()){
            return new int[0];
        }

        List<Integer> list = new ArrayList<>(Collections.nCopies(numsLength, null));

        int count = 0;

        while (count < k) {

            if(!pq.isEmpty()) {
                int max = pq.poll();
                System.out.println(max);
                List<Integer> num = map.get(max);
                list.set(num.get(0), max);
                num.remove(0);
                count++;
            }

        }

        return list.stream().filter(Objects::nonNull).mapToInt(i -> i).toArray();

    }
    int[] maxSubsequence2(int[] nums, int k) {

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (int i = 0; i < nums.length; i++) {
            queue.add(new int[]{i, nums[i]});
        }

        int count = 0;

        PriorityQueue<int[]> queue2 = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        while (count < k) {

            if(!queue.isEmpty()) {
                int[] temp = queue.poll();
                queue2.add(temp);
                count ++;
            }
        }

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {

            int[] temp = queue2.poll();
            res[i] = Objects.requireNonNull(temp)[1];
        }

        return res;

    }
}
