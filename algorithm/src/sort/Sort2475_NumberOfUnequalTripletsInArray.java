package sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sort2475_NumberOfUnequalTripletsInArray {
    /*
        0부터 시작하는 양의 정수 배열 nums가 주어집니다. 다음 조건을 만족하는 세쌍 (i, j, k)의 개수를 찾으세요:

        0 <= i < j < k < nums.length
        nums[i], nums[j], nums[k]는 서로 다릅니다.

        즉, nums[i] != nums[j], nums[i] != nums[k], nums[j] != nums[k]입니다.

        이러한 조건을 만족하는 세쌍의 개수를 반환하세요.
        Input: nums = [4,4,2,4,3]
        Output: 3

        배열에 가능한 조합들 먼저 적어놓고
        Map에서 가능한 조합들로 구할 수 있는 중복된 숫자 구해서
        조합에서 중복 숫자
        44243이면
        3 * 1 * 1 = 3;

        n개의 서로 다른 숫자에서 3개를 고를 때

        (n × (n-1) × (n-2))/6

     */

    public static int unequalTriplets(int[] nums) {

        Map<int[], Integer> map2 = new HashMap<>();

        int p1 = 0;
        int p2 = 1;
        int p3 = 2;

        while (p1 < nums.length - 2) {

            if(nums[p1] != nums[p2] && nums[p1] != nums[p3] && nums[p2] != nums[p3]) {
                int[] arr = new int[]{p1, p2, p3};
                map2.put(arr, map2.getOrDefault(arr, 0) + 1);
            }

            if(p3 < nums.length - 1) {
                p3 ++;
                continue;
            }

            if(p2 < nums.length - 2) {
                p2 ++;
                p3 = p2 + 1;
                continue;
            }

            if(p2 == nums.length - 2 && p3 == nums.length - 1) {
                p1 ++;
                p2 = p1 + 1;
                p3 = p2 + 1;
            }

        }

        int unequalTriplets = 0;

        for(Map.Entry<int[], Integer> entry : map2.entrySet()) {

            unequalTriplets += entry.getValue();
        }

        return unequalTriplets;

    }

    int unequalTriplets2(int[] nums) {

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int unequalTriplets = 0;
        List<Integer> values = new ArrayList<>(freq.values());

        // 빈도수들 사이에서 3개를 고르는 모든 조합에 대해 계산
        for (int i = 0; i < values.size() - 2; i++) {
            for (int j = i + 1; j < values.size() - 1; j++) {
                for (int k = j + 1; k < values.size(); k++) {
                    unequalTriplets += values.get(i) * values.get(j) * values.get(k);
                }
            }
        }

        return unequalTriplets;

    }

}
