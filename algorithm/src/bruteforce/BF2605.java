package bruteforce;

public class BF2605 {
    /*
        중복되지 않는 숫자들의 배열 nums1과 nums2가 주어집니다. 각 배열에서 최소한 하나의 숫자를 포함하는 가장 작은 수를 반환하세요.
        Input: nums1 = [4,1,3], nums2 = [5,7]
        Output: 15
     */
    public static int minNumber(int[] nums1, int[] nums2) {

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums1.length; i++) {

            String num1 = String.valueOf(nums1[i]);
            for (int j = 0; j < nums2.length; j++) {

                String num2 = String.valueOf(nums2[j]);

                int loopMax = Math.max(Integer.parseInt(num2), Integer.parseInt(num1));
                int loopMin = Math.min(Integer.parseInt(num1), Integer.parseInt(num2));
                String numStr = num1.equals(num2) ? num1 : loopMin + "" + loopMax;
                int num = Integer.parseInt(numStr);
                if(num <= min) {
                    min = num;
                }
            }
        }

        return min;
    }
}
