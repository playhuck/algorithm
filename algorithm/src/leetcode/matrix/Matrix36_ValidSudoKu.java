package leetcode.matrix;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class Matrix36_ValidSudoKu {
    /*
        9 x 9 스도쿠 보드가 유효한지 판단하세요. 채워진 칸만 다음 규칙에 따라 검증하면 됩니다:

        각 행은 1-9 숫자를 중복 없이 포함해야 합니다.
        각 열은 1-9 숫자를 중복 없이 포함해야 합니다.
        9개의 3x3 서브박스 각각이 1-9 숫자를 중복 없이 포함해야 합니다.

     */
    public boolean isValidSudoku(char[][] board) {

        for(int x = 0; x < board.length; x ++) {

            Set<Character> wSet = new HashSet<>();
            Set<Character> hSet = new HashSet<>();
            Set<Integer> boxSet = new HashSet<>();

            for(int y = 0; y < board[x].length; y ++) {

                char w = board[x][y] != '.' ? board[x][y] : '.';
                char h = board[y][x] != '.' ? board[y][x] : '.';
                int box = ((x / 3) * 3) + (y / 3);

                if(w != '.') {
                    if (wSet.contains(w)) return false;
                    else wSet.add(w);
                }

                if(h != '.') {
                    if (hSet.contains(h)) return false;
                    else hSet.add(h);
                }

                if(boxSet.contains(box)) return false;
                else boxSet.add(box);

            }
        }

        return true;

    }

    public boolean isValidSudoku2(char[][] board) {

        boolean[][] rows = new boolean[9][10];
        boolean[][] cols = new boolean[9][10];
        boolean[][] boxes = new boolean[9][10];

        for(int x = 0; x < board.length; x ++) {

            for(int y = 0; y < board[x].length; y ++) {

                if(board[x][y] == '.') continue;

                int num = board[x][y] - '0';
                int boxIndex = (x / 3) * 3 + (y / 3);

                if(rows[x][num] || cols[y][num] || boxes[boxIndex][num]) return false;
                rows[x][num] = true;
                cols[y][num] = true;
                boxes[boxIndex][num] = true;

            }
        }

        return true;

    }
}
