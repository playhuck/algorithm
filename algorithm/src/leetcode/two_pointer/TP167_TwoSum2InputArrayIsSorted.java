package leetcode.two_pointer;

public class TP167_TwoSum2InputArrayIsSorted {
    /*
        이미 비감소 순서로 정렬된 1부터 시작하는 정수 배열 numbers가 주어질 때,
        특정 target 숫자에 더해지는 두 숫자를 찾으세요.
        이 두 숫자를 numbers[index1]과 numbers[index2]라고 하며,
        여기서 1 <= index1 < index2 <= numbers.length입니다.
        길이가 2인 정수 배열 [index1, index2]로 두 숫자의 인덱스 index1과 index2를 반환하세요.
        테스트는 정확히 하나의 해답이 있도록 생성됩니다. 같은 원소를 두 번 사용할 수 없습니다.
        당신의 해결책은 일정한 추가 공간만 사용해야 합니다.

        Input: numbers = [2,7,11,15], target = 9
        Output: [1,2]
        Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

     */
    public int[] twoSum(int[] numbers, int target) {

        int p1 = 0;
        int p2 = numbers.length - 1;

        // 큰 순서대로 정렬됐기 때문에 p1 + p2가 target보다 큰 경우 p2를 앞으로 한단계 당기고
        // p1 + p2가 target보다 작은 경우 p1을 +=한다.
        while(p1 < numbers.length && p2 >= 0) {

            int sum = numbers[p1] + numbers[p2];

            if(sum == target) {
                return new int[]{p1 + 1, p2 + 1};
            }

            if(sum > target) {
                p2 --;
            } else {
                p1 ++;
            }

        }

        return new int[]{p1 + 1, p2 + 1};

    }
}
