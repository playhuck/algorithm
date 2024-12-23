package heap;

import java.util.TreeMap;

public class RE_Heap1438_LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
     /*
        정수 배열 nums와 정수 limit가 주어질 때,
        이 하위 배열의 모든 두 원소 간의 절대 차이가 limit 이하인 가장 긴 비어있지 않은 하위 배열의 크기를 반환하세요.
         [8,2,4,7], limit = 4
     */

    public static int longestSubarray(int[] nums, int limit) {
        // TreeMap: 키(숫자)를 자동으로 정렬하여 저장하는 자료구조
        // Integer(key): 숫자 값 자체 (nums[i])
        // Integer(value): 해당 숫자의 등장 횟수
        TreeMap<Integer, Integer> window = new TreeMap<>();

        // left: 윈도우의 시작 포인터
        int left = 0;
        // 조건을 만족하는 가장 긴 부분 배열의 길이
        int longestSubarray = 0;

        // right: 윈도우의 끝 포인터
        for (int right = 0; right < nums.length; right++) {
            // 현재 숫자를 TreeMap에 추가
            // getOrDefault: 해당 키가 존재하면 그 값을, 없으면 0을 반환
            // 즉, 기존 등장 횟수에 1을 더하거나, 새로운 숫자면 1로 설정
            window.put(nums[right], window.getOrDefault(nums[right], 0) + 1);

            // lastKey(): TreeMap에서 가장 큰 키 값 (최댓값)
            // firstKey(): TreeMap에서 가장 작은 키 값 (최솟값)
            // 현재 윈도우에서 최댓값과 최솟값의 차이가 limit를 초과하는 동안

            while (window.lastKey() - window.firstKey() > limit) {
                // left 위치의 숫자 등장 횟수를 1 감소
                window.put(nums[left], window.get(nums[left]) - 1);

                // 해당 숫자의 등장 횟수가 0이 되면
                // TreeMap에서 완전히 제거
                if (window.get(nums[left]) == 0) {
                    window.remove(nums[left]);
                }
                // 윈도우의 시작 포인터를 오른쪽으로 이동
                left++;
            }

            // 현재 윈도우의 길이(right - left + 1)와
            // 이전까지의 최대 길이를 비교하여 더 큰 값을 저장
            longestSubarray = Math.max(longestSubarray, right - left + 1);
        }

        return longestSubarray;
    }
}
