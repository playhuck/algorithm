package stack_queue;

public class Stack496_NextGreaterElementI {
    /*
       어떤 원소 x의 다음 큰 원소란 동일한 배열에서 x의 오른쪽에 있는 첫 번째 큰 원소를 의미합니다.
       0부터 시작하는 인덱스를 가진 두 개의 서로 다른 정수 배열 nums1과 nums2가 주어지며, nums1은 nums2의 부분집합입니다.
       각각의 0 <= i < nums1.length에 대해, nums1[i] == nums2[j]를 만족하는 인덱스 j를 찾고,
       nums2에서 nums2[j]의 다음 큰 원소를 결정하세요. 만약 다음 큰 원소가 없다면, 이 쿼리에 대한 답은 -1입니다.
       길이가 nums1.length인 배열 ans를 반환하세요. 여기서 ans[i]는 위에서 설명한 대로 다음 큰 원소여야 합니다.

       nums1의 값과 일치하는 nums2의 index를 찾아, 그 index 다음 이후의 nums2[j]의 값보다 큰 값을 return
    */
    int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {

            int num = nums1[i];

            int index = -1;

            boolean isFind = false;

            for (int j = 0; j < nums2.length; j++) {

                int num2 = nums2[j];
                if(num == num2) {
                    index = j;
                }

                if(index > -1 && num2 > num) {
                    result[i] = num2;
                    isFind = true;
                    break;
                }
            }

            if(!isFind) {
                result[i] = -1;
            }

        }

        return result;

    }
}
