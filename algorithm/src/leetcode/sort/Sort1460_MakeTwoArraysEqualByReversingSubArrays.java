package leetcode.sort;

import java.util.Arrays;

public class Sort1460_MakeTwoArraysEqualByReversingSubArrays {
    /*
        동일한 길이의 두 정수 배열 target과 arr이 주어집니다.
        한 단계에서, arr의 임의의 비어있지 않은 하위 배열을 선택하여 뒤집을 수 있습니다. 원하는 만큼의 단계를 수행할 수 있습니다.
        arr을 target과 동일하게 만들 수 있다면 true를, 그렇지 않으면 false를 반환하세요.

        (n × (n-1) × (n-2))/6

     */

    public static boolean canBeEqual(int[] target, int[] arr) {

        Arrays.sort(target);
        Arrays.sort(arr);

        return Arrays.equals(target, arr);

    }
}
