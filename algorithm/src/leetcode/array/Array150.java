package leetcode.array;

public class Array150 {

    /*
        k만큼 앞으로 배열을 밀어야 합니다. 공간의 효율화를 위해 새롭게 배열을 생성하지 않습니다.
        k는 음수는 나오지 않습니다.
        1 <= nums.length <= 105
        -231 <= nums[i] <= 231 - 1
        0 <= k <= 105 k가 length 보다 커질 수 있습니다.
     */

    public void rotate(int[] nums, int k) {

        int n = nums.length;
        k = k % n; // k는 k % n으로 업데이트되어 k가 n보다 큰 경우를 처리합니다.
        int[] rotated = new int[n]; // 회전을 위한 새로운 배열을 생성합니다.

        for(int i = 0; i <n; i ++) {
            rotated[(i + k) % n] = nums[i]; // (i + k) % n 에서 n으로 나눠줘야 다시 0부터 돌기시작함
        }

        System.arraycopy(rotated, 0, nums, 0, n);
        //                원본배열, 원본 배열에서 복사를 시작할 위치, 복사 대상 배열, 복사할 요소의 개수

    }

    public void rotate2(int[] nums, int k) {

        int n = nums.length;
        k = k % n;
        if(k == 0) return;

        int[] temp = new int[n];
        System.arraycopy(nums, n - k, temp, 0, k);
        System.arraycopy(nums, 0, nums, k, n - k);
        System.arraycopy(temp, 0, nums, 0, n);

    }
}
