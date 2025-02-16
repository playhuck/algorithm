package leetcode.bruteforce;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BF989 {

    /*

        BigInteger를 사용한, 날먹 방식

        정수의 배열 형태(array-form)란 해당 정수의 각 자릿수를 왼쪽에서 오른쪽 순서로 나타낸 배열을 의미합니다.

        예를 들어, num = 1321의 배열 형태는 [1,3,2,1]입니다.

        정수의 배열 형태인 num과 정수 k가 주어질 때, num + k의 배열 형태를 반환하세요. Copy
     */

    public static List<Integer> addToArrayForm(int[] num, int k) {

        String[] strings = Arrays
                .stream(num)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        BigInteger parseNum = new BigInteger(String.join("", strings));

        BigInteger numK = parseNum.add(BigInteger.valueOf(k));

        return Arrays
                .stream(String.valueOf(numK).split(""))
                .map(Integer::parseInt)
                .toList();
    }

     /*
        자릿수 분해의 원리를 사용한 메모리 효율 극강 방식

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

    public static List<Integer> addToArrayForm2(int[] num, int k) {

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
