package leetcode.matrix;

import java.util.ArrayList;
import java.util.List;

public class Matrix54_SpiralMatrix {
    /*
        m x n matrix가 주어질 때, 행렬의 모든 요소를 나선형 순서로 반환하세요.
     */
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> ans = new ArrayList<>();

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        int p1 = 0;
        int p2 = 0;
        int count = matrix.length * matrix[0].length;
        String state = "right";

        /*
            오른쪽 / 아래 / 왼쪽 / 위 / 오른쪽 ...
            현재 상태에서 다음으로 갈 수 없다면 종료

            right일 때는 p2++; => 인덱스를 넘기거나 오른쪽 인덱스가 true인 경우
            down일 때는 p1++;
            left일 때는 p2--;
            top일 때는 p1--;
         */

        int width = matrix[0].length;
        int height = matrix.length;

        while (count > 0) {

            int cur = matrix[p1][p2];
            System.out.println(p1 + " " + p2);
            visited[p1][p2] = true;
            ans.add(cur);

            switch (state) {
                case "right" -> {

                    if (p2 == width - 1 ||
                            (p2 < width - 1 && visited[p1][p2 + 1])
                    ) {
                        state = "down";
                        p1++;
                    } else p2++;
                }
                case "down" -> {

                    if (p1 == height - 1 ||
                            (p1 < height - 1 && visited[p1 + 1][p2])
                    ) {
                        state = "left";
                        p2--;
                    } else p1++;
                }
                case "left" -> {
                    if (p2 == 0 || visited[p1][p2 - 1]
                    ) {
                        state = "up";
                        p1--;
                    } else p2--;
                }
                default -> {
                    if (
                            p1 == 0 || visited[p1 - 1][p2]
                    ) {
                        state = "right";
                        p2++;
                    } else p1--;
                }
            }

            count --;

        }

        return ans;
    }
}
