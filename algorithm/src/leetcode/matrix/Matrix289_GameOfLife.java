package leetcode.matrix;

import java.util.Objects;

public class Matrix289_GameOfLife {

    public void gameOfLife(int[][] board) {

        int colLen = board.length;
        int rowLen = board[0].length;
        int[][] renewBoard = new int[colLen][rowLen];

        for(int x = 0; x < colLen; x++){

            for(int y = 0; y < rowLen; y++){

                int cur = board[x][y];
                int count = 0;

                int leftTop = x - 1 >= 0 && y - 1 >= 0 ? board[x - 1][y - 1] : 0;
                int top = x - 1 >= 0 ? board[x - 1][y] : 0;
                int rightTop = x - 1 >= 0 && y + 1 < rowLen ? board[x - 1][y + 1] : 0;  // 좌표 수정!
                int left = y - 1 >= 0 ? board[x][y - 1] : 0;
                int right = y + 1 < rowLen ? board[x][y + 1] : 0;
                int leftDown = x + 1 < colLen && y - 1 >= 0 ? board[x + 1][y - 1] : 0;
                int down = x + 1 < colLen ? board[x + 1][y] : 0;
                int rightDown = x + 1 < colLen && y + 1 < rowLen ? board[x + 1][y + 1] : 0;

                if(leftTop > 0) count++;
                if(top > 0) count++;
                if(rightTop > 0) count++;
                if(left > 0) count++;
                if(right > 0) count++;
                if(leftDown > 0) count++;
                if(down > 0) count++;
                if(rightDown > 0) count++;

                if(cur > 0 && count < 2) renewBoard[x][y] = 0;
                else if(cur > 0 && ( count ==2 || count == 3)) renewBoard[x][y] = 1;
                else if(cur > 0) renewBoard[x][y] = 0;
                else if(cur == 0 && count == 3) renewBoard[x][y] = 1;
                else {
                    renewBoard[x][y] = cur;
                }


            }

        }

        for(int i = 0; i < colLen; i++) {
            for(int j = 0; j < rowLen; j++) {
                board[i][j] = renewBoard[i][j];
            }
        }

    }

}
