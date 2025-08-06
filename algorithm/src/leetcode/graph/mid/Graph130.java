package leetcode.graph.mid;

public class Graph130 {

    /*
        'X'와 'O' 문자를 포함하는 m x n 행렬 board가 주어졌을 때, 둘러싸인 영역을 캡처하세요.
        연결: 한 칸(cell)은 가로 또는 세로로 인접한 칸들과 연결됩니다.
        영역: 모든 'O' 칸들을 연결하여 영역을 형성합니다.
        둘러싸임: 어떤 영역이 board의 가장자리에 있는 칸과 연결되지 않고 X 칸들로 둘러싸여 있다면, 그 영역은 둘러싸인 것입니다.
        둘러싸인 영역을 캡처하려면, 그 영역 내의 모든 'O'를 'X'로 원래의 행렬에서 직접 바꾸세요. 별도로 반환할 필요는 없습니다.

        가장자리랑 연결되지 않은 O는 X로 바꾸고, 가장 자리랑 연결된 O는 그대로 둔다.

        O를 처음 발견하면, 체킹을 시작하는데 만약 가장자리랑 연결된 녀석들이라면 true로 변경하고 탐색에서 제외합니다.
        boolean[][] 배열만들어서 가장자리로 둘러쌓인 녀석들은 넘기고
        가장자리부터 탐색해서 바꿔보고, 가장자리에 O가 발견된다면 그녀석 기준으로 helper 돌리는게 베스트

        0번째 행
        0번째 열
        마지막 행
        마지막 열
     */

    int n;
    int m;

    public void solve(char[][] board) {

        if(board.length == 0) return;

        m = board.length;
        n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < n; i++) {

            char row = board[0][i];
            if(visited[0][i]) {
                continue;
            }
            if(row == 'O') {
                helper(board, visited, 0, i);
            }

        }

        for(int i = 0; i < m; i ++) {

            char col = board[i][0];
            if(visited[i][0]) {
                continue;
            }
            if(col == 'O') {
                helper(board, visited, i, 0);
            }
        }

        for(int i = 0; i < m; i ++) {
            char row = board[m][i];
            if(visited[m][i]) {
                continue;
            }
            if(row == 'O') {
                helper(board, visited, m, i);
            }
        }

        for(int i = n - 1; i >= 0; i --) {

            char row = board[i][m - 1];
            if(visited[i][m - 1]) {
                continue;
            }
            if(row == 'O') {
                helper(board, visited, i, m - 1);
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

        if(i < 0 || j < 0 || board[i][j] != 'O' || i >= m || j >= n) return;

        if(board[i][j] == 'O') {
            System.out.println("i : " + i + ", j : " + j);
        }
        visited[i][j] = true;

        helper(board, visited, i + 1, j);
        helper(board, visited, i - 1, j);
        helper(board, visited, i, j + 1);
        helper(board, visited, i, j - 1);
    }

}
