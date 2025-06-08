package leetcode.matrix;

public class Matrix73_SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {

        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        boolean[][] changes = new boolean[rowLen][colLen];

        /*
            0이된 열과 행을 표시합니다.
         */

        for(int x = 0; x < rowLen; x++) {

            for(int y = 0; y < colLen; y++) {

                int cur = matrix[x][y];
                if(changes[x][y]) { continue; }
                if(cur == 0) {


                    for (int z = 0; z < colLen; z++) {

                        int r = matrix[x][z];
                        if (r != 0 && y != z) {
                            matrix[x][z] = 0;
                            changes[x][z] = true;
                        }

                    }

                    for (int z = 0; z < rowLen; z++) {

                        int c = matrix[z][y];
                        System.out.println(c);
                        if (c != 0 && y != z) {
                            matrix[z][y] = 0;
                            changes[z][y] = true;
                        }
                    }

                }
            }

        }

    }

    public void setZeroes2(int[][] matrix) {

        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        boolean[][] changes = new boolean[rowLen][colLen];

        /*
            0이된 열과 행을 표시합니다.
         */

        for(int x = 0; x < rowLen; x++) {

            for(int y = 0; y < colLen; y++) {

                int cur = matrix[x][y];
                if(changes[x][y]) { continue; }
                if(cur == 0) {
                }
            }

        }

    }

}
