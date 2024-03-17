package jechul;

class 파괴되지않은건물 {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int N = board.length;
        int M = board[0].length;
        int[][] arr = new int[N+1][M+1];

        for (int[] s : skill) {
            int type = s[0];
            int r1 = s[1];
            int c1 = s[2]; 
            int r2 = s[3];
            int c2 = s[4];
            int degree = s[5];
            
            if (type == 1) {
                degree = -degree;
            }
            
            arr[r1][c1] += degree;
            arr[r1][c2+1] -= degree;
            arr[r2+1][c1] -= degree;
            arr[r2+1][c2+1] += degree;
        }


        for (int i = 0; i < N; i++) {
            for (int j = 1; j < M; j++) {
            	arr[i][j] += arr[i][j-1];
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
            	arr[i][j] += arr[i-1][j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] += arr[i][j];
                if (board[i][j] > 0) answer++;
            }
        }

        return answer;
    }
}

