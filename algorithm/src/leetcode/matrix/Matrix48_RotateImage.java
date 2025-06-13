package leetcode.matrix;

public class Matrix48_RotateImage {

    /*
        이미지를 나타내는 n x n 2D matrix가 주어질 때,
        이미지를 90도 시계방향으로 회전시키세요.
        이미지를 제자리에서(in-place) 회전시켜야 합니다.
        즉, 입력 2D 행렬을 직접 수정해야 합니다. 다른 2D 행렬을 할당하지 마세요.
     */
    public void rotate(int[][] matrix) {

        int len = matrix.length;
        boolean[][] visited = new boolean[len][len];

        for(int x = 0; x < matrix.length; x++){

            for(int y = 0; y < matrix.length; y++){

                if(visited[x][y]) continue;

                int rotate1 = matrix[x][y];
                int rotate2 = matrix[y][len - 1 - x];

                visited[x][y] = true;
                visited[y][len - 1 - x] = true;
                matrix[x][y] = rotate2;
                matrix[y][len - 1 - x] = rotate1;

            }
        }

    }

}
