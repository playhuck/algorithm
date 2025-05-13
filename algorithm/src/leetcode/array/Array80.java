package leetcode.array;

public class Array80 {

    class Solution {
        public int removeDuplicates(int[] nums) {

            int i = 0;
            // 두 조건을 만족해야 합니다.
            // 1. 총 몇개 있는지 , 2. 배열을 앞으로 당기는 작업도 수행해야 한다.

            for(int n : nums) {

                // i가 2보다 작은 경우(초반)
                // n(현재값)이 nums[i - 2](포인터가 가리키는 2보다 큰 값)
                if( i < 2 || n > nums[i - 2]) {
                    nums[i++] = n;
                }
            }

            return i;
        }
    }

}
