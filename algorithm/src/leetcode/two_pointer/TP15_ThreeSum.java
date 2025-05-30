package leetcode.two_pointer;

import java.util.*;

public class TP15_ThreeSum {
    /*
        정수 배열 nums가 주어질 때, i != j, i != k, j != k이고 nums[i] + nums[j] + nums[k] == 0인
        모든 삼조 [nums[i], nums[j], nums[k]]를 반환하세요.
        해답 집합에는 중복된 삼조가 포함되어서는 안 됩니다.

        1. ijk는 모두 달라야 한다.
        2. 3개의 값을 합쳐서 0을 만들어야 한다.
            - 0을 절대 못만드는 경우 제외 > 모든 값이 음수인 경우 / 모든 값이 양수인 경우
            - 0을 만들 수 있는 경우 > 음수 + 양수 / 음수 + 양수 + 0
        3. 3개의 포인터 p1 p2 p3
            - p1은 0부터 / p2는 끝에서부터 / p3는 p1보다 앞에서
     */
    public List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums); // 내림차순 정렬

        int len = nums.length;
        if(nums[len - 1] < 0 || nums[0] > 0) return new ArrayList<>();

        for(int i = 0; i < len - 2; i++) {

            if(nums[i] > 0) continue;

            int left = i + 1;
            int right = len - 1;

            while(left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if(sum == 0) {
                    List<Integer> addList = Arrays.asList(nums[left], nums[right], nums[i]);
                    Collections.sort(addList);
                    set.add(addList);
                    left ++;
                    right --;
                } else {

                    if(sum < 0) {
                        left ++;
                    } else {
                        right --;
                    }
                }
            }

        }

        System.out.println(Arrays.toString(nums));

        return set.stream().toList();
    }
}
