package leetcode.heap;

public class Heap1464_MaximumProductOfTwoElementsInArray {
    /*
        정수 배열 nums가 주어질 때, 당신은 그 배열에서 서로 다른 두 개의 인덱스 i와 j를 선택할 것입니다.
        (nums[i]-1)*(nums[j]-1)의 최대값을 반환하세요.
     */


    public static int maxProduct(int[] nums) {

        int max = 0;
        int subMax = 0;

        for (int num : nums) {

            if (num > max) {
                subMax = max;
                max = num;
            } else if (num >= subMax) {
                subMax = num;
            }
        }

        return (max - 1) * (subMax + 1);
    }
}
