package leetcode.dfs;

public class DFS463 {
    /*
        row x col 크기의 grid가 주어지며, 이는 지도를 나타냅니다. grid[i][j] = 1은 육지를, grid[i][j] = 0은 물을 나타냅니다.

        격자 셀들은 가로/세로로 연결되어 있습니다(대각선으로는 연결되지 않음).
        grid는 완전히 물로 둘러싸여 있으며, 정확히 하나의 섬(즉, 하나 이상의 연결된 육지 셀)이 있습니다.

        섬에는 "호수"가 없습니다. 즉, 섬 내부의 물은 섬 주변의 물과 연결되어 있지 않습니다.
        한 셀은 변의 길이가 1인 정사각형입니다. 격자는 직사각형이며, 너비와 높이는 100을 초과하지 않습니다. 섬의 둘레를 구하세요.
     */

    public int islandPerimeter(int[][] grid) {

        int perimeter = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                int square = grid[i][j];
                if(square == 1) {

                    square = 4;
                    if(j - 1 >= 0) {
                        if(grid[i][j -1] == 1) square--;
                    }
                    if(j + 1 < grid[i].length) {
                        if(grid[i][j + 1] == 1) square--;
                    }
                    if(i - 1 >= 0){
                        if(grid[i - 1][j] == 1) square--;
                    }
                    if(i + 1 < grid.length) {
                        if(grid[i + 1][j] == 1) square--;
                    }

                    perimeter += square;
                }
            }
        }

        return perimeter;

    }
}
