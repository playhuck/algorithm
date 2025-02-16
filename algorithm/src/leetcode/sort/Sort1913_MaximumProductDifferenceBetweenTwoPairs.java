package leetcode.sort;

import java.util.*;

public class Sort1913_MaximumProductDifferenceBetweenTwoPairs {
    /*
        곱의 차이는 두 쌍 (a, b)와 (c, d) 사이에서 (a * b) - (c * d)로 정의됩니다.

        예를 들어, (5, 6)과 (2, 7) 사이의 곱의 차이는 (5 * 6) - (2 * 7) = 16입니다.

        정수 배열 nums가 주어질 때, 쌍 (nums[w], nums[x])와 (nums[y], nums[z])
        사이의 곱의 차이가 최대가 되도록 하는 네 개의 서로 다른 인덱스 w, x, y, z를 선택하세요.
        최대 곱의 차이를 반환하세요.

     */

    public static int maxProductDifference(int[] nums) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> max = new ArrayList<>(2);
        List<Integer> min = new ArrayList<>(2);

        if(Objects.equals(map.lastKey(), map.firstKey())){
            return 0;
        }

        max.add(map.lastKey());
        if(map.get(map.lastKey()) > 0) {
            map.put(map.lastKey(), map.get(map.lastKey()) - 1);
            if(map.get(map.lastKey()) == 0) {
                map.remove(map.lastKey());
            }
        } else {
            map.remove(map.lastKey());
        }
        max.add(map.lastKey());

        min.add(map.firstKey());
        if(map.get(map.firstKey()) > 0) {
            map.put(map.firstKey(), map.get(map.firstKey()) - 1);
            if(map.get(map.firstKey()) == 0) {
                map.remove(map.firstKey());
            }
        } else {
            map.remove(map.firstKey());
        }
        min.add(map.firstKey());

        return (max.get(0) * max.get(1)) - (min.get(0) * min.get(1));

    }

    int maxProductDifference2(int[] nums) {

        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();

        for (int num : nums) {
            max.add(num);
            min.add(num);
        }

        return (max.poll() * max.poll()) - (min.poll() * min.poll());

    }

    int maxProductDifference3(int[] nums) {

        Arrays.sort(nums);

        return (nums[nums.length - 1] * nums[nums.length - 2]) - (nums[0] * nums[1]);

    }
}
