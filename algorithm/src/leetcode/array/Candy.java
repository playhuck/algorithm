package leetcode.array;

import java.util.*;

public class Candy {

    /*
        1 <= n <= 2 * 104
        0 <= ratings[i] <= 2 * 104
     */

    public int candy2(int[] ratings) {

        int c = 0;
        int len = ratings.length;
        int[] candies = new int[len];
        Arrays.fill(candies, 1);

        for(int i = 1; i < len; i ++) {
            if(ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        for(int i = len - 2; i >= 0; i--) {

            if(ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
            }
        }

        int sumCandy = 0;
        for(int i = 0; i < len; i++) {

            sumCandy += Math.max(candies[i], candies[i]);
        }

        return sumCandy;

    }

    public int candy(int[] ratings) {

        int len = ratings.length;

        Map<Integer, List<int[]>> mMap = getMinimumRateMap(ratings, len);

        int mRate = mMap.get(Integer.MIN_VALUE).get(0)[1];
        List<int[]> mList = mMap.get(mRate); // 최소 값이 담긴 배열안의 배열
        // 이전 값과 그 이전 값도 알아야 한다. len은 1이상
        int lastSearchIdx = 0;
        int[] arr = new int[len];

        for(int i = 0; i < mList.size(); i++) {

            int mIdx = mList.get(i)[0];
            int lastCandy = 0;
            for(int k = mIdx; k >= lastSearchIdx; k--) {

                if(arr[k] == lastSearchIdx && arr[k] == 1) continue;

                if(k != mIdx) {

                    if(ratings[k] > ratings[k + 1]) {
                        arr[k] = lastCandy + 1; lastCandy++;
                    } else if (ratings[k] == ratings[k + 1]) {
                        if(k > 0 && ratings[k] == ratings[k - 1]) {
                            arr[k] = lastCandy == 1 ? 1 : lastCandy - 1;
                            lastCandy --;
                        } else if(k > 0 && ratings[k] > ratings[k - 1]) {
                            arr[k] = lastCandy + 1;
                            lastCandy ++;

                        } else {
                            arr[k] = lastCandy == 1 ? 1 : lastCandy - 1;
                            lastCandy --;
                        }

                    } else {
                        arr[k] = 1;
                        lastCandy = 1;
                    }
                } else {

                    // 오른쪽 보다 작고 왼쪽보다 크다면 현상 유지
                    // 오른쪽 보다 작고 왼쪽이랑 같다면, -1
                    if(k > 0 && ratings[k] > ratings[k-1]) {
                        arr[k] = lastCandy;
                    } else {
                        arr[k] = 1;
                        lastCandy = 1;
                    }

                }
            }

            lastSearchIdx = mIdx;
        }
        // 왼쪽 값 모두 처리 마지막 오른쪽 루프만 돌면됨

        int[] lastList = mMap.get(mRate).get(mMap.get(mRate).size() - 1); // 최소 값이 담긴 배열안의 배열
        int lastCandy = 0;
        for(int k = lastList[0]; k < len; k ++) {

            if(lastList[0] == k) {
                arr[k] = 1;
                lastCandy = 1;
                continue;
            }

            System.out.println(ratings[k] + " " + ratings[k - 1] + " " + lastCandy);

            if (ratings[k] > ratings[k - 1]) {
                arr[k] = ++lastCandy;
            } else if (ratings[k] == ratings[k - 1]) {

                if(k < len && ratings[k] == ratings[k - 1]) {
                    arr[k] = lastCandy == 1 ? 1 : --lastCandy;
                } else if(k < len && ratings[k] > ratings[k - 1]) {
                    arr[k] = ++lastCandy;

                } else arr[k] = lastCandy == 1 ? 1 : --lastCandy;
            } else {

                if(k < len && ratings[k] > ratings[k+1]) {
                    arr[k] = lastCandy == 1 ? 1 : --lastCandy;
                } else {
                    arr[k] = 1;
                    lastCandy = 1;
                }
            }
        };

        int candy = 0;

        for(int c : arr) {
            candy += c;
        }

        System.out.println(mRate);
        System.out.println(Arrays.toString(arr));

        return candy;

    }

    public Map<Integer, List<int[]>> getMinimumRateMap(int[] ratings, int len) {

        int mRate = Integer.MAX_VALUE;
        Map<Integer, List<int[]>> mMap = new HashMap<>(); // 각 값별 최소값이 담길 배열을 보관할 Map
        for (int i = 0; i < len; i++) {
            int rating = ratings[i];
            mRate = Math.min(mRate, rating);
            if (!mMap.containsKey(rating)) {
                mMap.put(rating, new ArrayList<>(len));
                mMap.get(rating).add(new int[]{i, rating});
            } else {
                mMap.get(rating).add(new int[]{i, rating});
            }
        }
        mMap.put(Integer.MIN_VALUE, new ArrayList<>());
        mMap.get(Integer.MIN_VALUE).add(new int[]{0, mRate});

        return mMap;

    }
}
