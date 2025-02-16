package leetcode.array;

public class Array605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int ploted = n;
        int len = flowerbed.length;

        for(int i = 0; i < len; i ++) {

            if(len == 1 && flowerbed[i] == 0 && n == 1) {
                return true;
            }

            int left = i - 1;
            int right = i + 1;
            boolean plotLeft = false;
            boolean plotRight = false;

            if(flowerbed[i] == 0) {
                if(left >= 0 && flowerbed[left] == 0) {
                    plotLeft = true;
                }
                if(right < len && flowerbed[right] == 0) {
                    plotRight = true;
                }

                if(i == 0 && plotRight) {
                    flowerbed[i] = 1;
                    n --;
                    continue;
                } else if(i == (len - 1) && plotLeft) {
                    flowerbed[i] = 1;
                    n --;
                    continue;
                } else {

                    if(plotLeft && plotRight) {
                        flowerbed[i] = 1;
                        n --;
                    }
                }
            }

        }

        return n <= 0;

    }
}
