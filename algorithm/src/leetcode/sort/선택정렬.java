package leetcode.sort;

public class 선택정렬 {

    class Solution {
        public int solution(int[] array) {
            int answer = 0;

            if(array.length == 0){
                return answer;
            }

            for (int i = 0; i <array.length; i++) {

                int min = i;
                for (int j = i + 1; j <array.length; j++) {

                    if(array[min] > array[j]) {
                        min = j;
                    }

                }

                int temp =  array[min];
                array[min] = array[i];
                array[i] = temp;

            }

            return answer;
        }
    }

    class Solution2 {
        public int solution(int[] numbers) {

            int max;
            for (int i = 0; i <numbers.length ; i++) {

                max = i;
                for (int j = i+1; j < numbers.length; j++) {

                    if(numbers[j] > numbers[max]) {
                        max = j;
                    }
                }

                int temp = numbers[i];
                numbers[i] = numbers[max];
                numbers[max] = temp;
            }


            return Math.max(numbers[0] * numbers[1], numbers[numbers.length - 1] * numbers[numbers.length - 2]);

        }
    }

}
