package leetcode.bruteforce;

public class BF2511 {
    public static int captureForts(int[] forts) {

        int captureMax = 0;

        /*
            출발은 언제나 1에서 (isCapture true)
            도착은 언제나 -1에서 (isCapture false)

            1 -> 오른쪽 이동 가능
            1 -< 왼쪽 이동 가능

            끝은 항상 언제나 -1이어야한다.
         */

        for (int i = 0; i < forts.length; i++) {

            int rightCount = 0;
            int leftCount = 0;

            if(forts[i] == 1) {

                for (int j = 1; j < forts.length; j++) {

                    if(rightCount == Integer.MIN_VALUE && leftCount == Integer.MIN_VALUE) {
                        break;
                    }

                    int right = i + j;
                    int left = i - j;

                    if (right < forts.length && forts[right] == 0) rightCount++;

                    if (left > -1 && forts[left] == 0) leftCount++;

                    if (right < forts.length && rightCount != Integer.MIN_VALUE) {

                        if(forts[right] == -1) {
                            captureMax = Math.max(captureMax, rightCount);
                            rightCount = Integer.MIN_VALUE;
                        }

                        if(forts[right] == 1) {
                            rightCount = Integer.MIN_VALUE;
                        }
                    }

                    if(left > -1 && leftCount != Integer.MIN_VALUE) {

                        if(forts[left] == -1) {
                            captureMax = Math.max(captureMax, leftCount);
                            leftCount = Integer.MIN_VALUE;
                        }

                        if(forts[left] == 1) {
                            leftCount = Integer.MIN_VALUE;
                        }

                    }

                }
            }

        }

        return captureMax;
    }
}
