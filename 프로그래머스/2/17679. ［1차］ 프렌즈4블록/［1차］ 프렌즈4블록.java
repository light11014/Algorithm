class Solution {
    public int solution(int m, int n, String[] board) {
        char[][] boardArr = new char[m][n];
        
        for(int i = 0; i < m; i++) {
            boardArr[i] = board[i].toCharArray();
        }
        
        int answer = 0;
        
        while(true) {
            // 찾기
            boolean[][] deleted = new boolean[m][n];
            boolean found = false;

            for(int row = 0; row < m - 1; row++) {
                for(int col = 0; col < n - 1; col++) {
                    char cur = boardArr[row][col];

                    if(cur != 0 
                      && boardArr[row + 1][col] == cur
                      && boardArr[row][col + 1] == cur
                      && boardArr[row + 1][col + 1] == cur) {
                        deleted[row][col] = true;
                        deleted[row + 1][col] = true;
                        deleted[row][col + 1] = true;
                        deleted[row + 1][col + 1] = true;
                        found = true;
                    }
                }
            }
            
            if(!found) {
                break;
            }

            // 지우기
            for(int row = 0; row < m; row++) {
                for(int col = 0; col < n; col++) {
                    if(deleted[row][col]) {
                        boardArr[row][col] = 0;
                        answer++;
                    }
                }
            }

            // 밀기
            for(int col = 0; col < n; col++) {
                int write = m - 1;

                for(int row = m - 1; row >= 0; row--) {
                    if(boardArr[row][col] != 0) {
                        boardArr[write][col] = boardArr[row][col];
                        write--;
                    }
                }

                while (write >= 0) {
                    boardArr[write][col] = 0;
                    write--;
                }
            }
        }
        
        
        return answer;
    }
    
}