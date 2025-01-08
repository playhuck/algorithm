package two_pointer;

import java.util.Arrays;

public class TP88 {
    /*
        비감소 순서로 정렬된 두 정수 배열 nums1과 nums2,
        그리고 각각 nums1과 nums2의 원소 개수를 나타내는 두 정수 m과 n이 주어집니다.
        nums1과 nums2를 비감소 순서로 정렬된 하나의 배열로 병합하세요.
        최종 정렬된 배열은 함수에서 반환하지 않고, 대신 nums1 배열 안에 저장되어야 합니다.
        이를 수용하기 위해 nums1의 길이는 m + n이며, 처음 m개의 원소는 병합되어야 할 원소들을 나타내고,
        마지막 n개의 원소는 0으로 설정되어 있으며 무시되어야 합니다. nums2의 길이는 n입니다.

        Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        Output: [1,2,2,3,5,6]

        Input: nums1 = [0], m = 0, nums2 = [1], n = 1
        Output: [1]
     */

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        if(n == 0) {
            return;
        }

        if(m == 0) {

            for (int i = 0; i < nums2.length; i++) {
                nums1[i] = nums2[i];
            }

            return;
        }

        int p1 = n - 1;
        int p2 = m - 1;

        int i = nums1.length - 1;

        while (p2 >= 0) {

            if(p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[i] = nums1[p1];
                p1 --;
            } else {
                nums1[i] = nums2[p2];
                p2 --;
            }

            i--;

        }

        System.out.println(Arrays.toString(nums1));

    }
}
