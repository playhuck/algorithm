import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {

    public static void main(String[] args) {

//        System.out.println(countGoodRectangles(
//                new int[][]{{5,8},{3,9},{5,12},{16,5}}
//        ));
//        System.out.println(countCharacters(
//                new String[]{"cat","bt","hat","tree"}
//        ));
//        System.out.println(minNumber(
//                new String[]{"hello","world","leetcode"}, "welldonehoneyr"
//        ));
//        System.out.println(minNumber(
//                new int[]{3,5,2,6}, new int[]{3,1,7}
//        ));
        System.out.println(addToArrayForm(
                new int[]{9,9,9,9,9,9,9,9,9,9}, 1
        ));
//        System.out.println(captureForts(
//                new int[]{-1,-1,0,1,0,0,1,-1,1,0}
//        ));
    }

    /*
        자릿수 분해의 원리

        각 단계에서:

        - 새로운 k = (현재 자리 숫자 + 이전 k) ÷ 10
        - 현재 자리에 남는 수 = (현재 자리 숫자 + 이전 k) % 10

        진법 변환의 원리

        - 이 과정은 본질적으로 10진수 덧셈을 수행하면서
        - 각 자리에서 발생하는 올림수(carry)를 다음 자리로 전달하는 과정입니다.
        - k를 carry로 사용함으로써 메모리를 효율적으로 사용할 수 있습니다.

        이 방식은 큰 숫자의 덧셈을 각 자릿수별로 나누어 처리하는 전통적인 암산 방식과 유사합니다.

        LinkedList를 사용하는 주된 이유,
        - ArrayList는 맨 앞에 요소를 추가할 때 O(n)의 시간이 필요 (모든 요소를 한 칸씩 뒤로 밀어야 함)
        - LinkedList는 맨 앞에 요소를 추가할 때 O(1)의 시간만 필요 (포인터만 변경)

        동적 크기 조정
        - 이 알고리즘에서는 결과의 자릿수가 입력보다 커질 수 있음
        - LinkedList는 크기 조정이 필요 없음
        - ArrayList는 내부 배열 크기를 재조정해야 할 수 있음
        맨 앞에 1을 추가해야 하는데, LinkedList를 사용하면 이 작업이 매우 효율적
     */

    public static List<Integer> addToArrayForm(int[] num, int k) {

        List<Integer> result = new LinkedList<>();

        for (int i = num.length - 1; i >= 0; i--) {

            result.add(0, (num[i] + k) % 10);

            k = (num[i] + k) / 10;
        }

        while (k > 0) {

            result.add(0, k % 10);

            k /= 10;
        }

        return result;
    }
}