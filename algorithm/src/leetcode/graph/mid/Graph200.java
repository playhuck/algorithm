package leetcode.graph.mid;

public class Graph200 {

    /*
        '1' (육지)과 '0' (물)로 이루어진 m x n 크기의 2차원 이진 그리드 grid가 주어졌을 때, 섬의 개수를 반환하세요.
        섬은 물에 의해 둘러싸여 있으며, 인접한 육지들을 가로 또는 세로로 연결하여 형성됩니다.
        그리드의 네 가장자리는 모두 물로 둘러싸여 있다고 가정할 수 있습니다.

        0으로 둘러 쌓여 있다면 섬! -> 섬은 1이 겹치는 라인이 없기 때문에
     */

    int n;
    int m;

    public void solve(char[][] board) {

        if(board.length == 0) return;

        m = board.length;
        n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        // 첫 번째 행과 마지막 행 탐색
        for (int i = 0; i < n; i++) {
            // 첫 번째 행의 'O' 탐색
            if (board[0][i] == 'O') {
                helper(board, visited, 0, i);
            }
            // 마지막 행의 'O' 탐색
            if (board[m - 1][i] == 'O') {
                helper(board, visited, m - 1, i);
            }
        }

        // 첫 번째 열과 마지막 열 탐색 (모서리 중복 탐색 방지를 위해 i=0, i=m-1 제외)
        for (int i = 1; i < m - 1; i++) {
            // 첫 번째 열의 'O' 탐색
            if (board[i][0] == 'O') {
                helper(board, visited, i, 0);
            }
            // 마지막 열의 'O' 탐색
            if (board[i][n - 1] == 'O') {
                helper(board, visited, i, n - 1);
            }
        }

        for(int i = 0; i < m; i ++) {

            for(int j = 0; j < n; j ++) {

                if(!visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }

    }


    /*
        처음부터 true로 시작하는게 낫다. true true true true로 바꾸고
        true 아닌 것들만 전부 X로 바꾸는게 제일 낫다는 의견
     */
    public void helper(char[][] board, boolean[][] visited, int i, int j) {

        if(i < 0 || j < 0 || i >= m || j >= n || board[i][j] != 'O') return;

        if(visited[i][j]) return;

        visited[i][j] = true;

        helper(board, visited, i - 1, j);
        helper(board, visited, i + 1, j);
        helper(board, visited, i, j - 1);
        helper(board, visited, i, j + 1);

    }
}
