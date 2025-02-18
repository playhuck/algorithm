package leetcode.map;

import java.util.HashMap;
import java.util.Map;

public class Map2352 {
    public int equalPairs(int[][] grid) {

        Map<String, Integer> map = new HashMap<>();

        int len = grid.length;
        int result = 0;

        for(int i = 0; i < len; i ++) {

            String str = "";

            for(int j = 0; j< len; j ++) {

                int row = grid[i][j];

                str += (row + "a");

            }

            map.put(str, map.getOrDefault(str, 0) + 1);

        }

        for(int i = 0; i < len; i ++) {

            String str = "";

            for(int j = 0; j< len; j ++) {

                int col = grid[j][i];

                str += (col + "a");

            }

            if(map.containsKey(str)) {
                result += map.get(str);
            }

        }

        return result;

    }
}
