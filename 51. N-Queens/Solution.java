class Solution {
    HashSet<Integer> col = new HashSet<>(); //only one queue each column
    HashSet<Integer> diff = new HashSet<>(); //only one queue per diag from top left to bottom right
    HashSet<Integer> sum = new HashSet<>(); //only one queue per diag from top right to bottom left
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        
        //corner case
        if (n <= 0) return res;
        //init board, using char[][]
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        dfs(0, n, board, res);
        return res;
        
    }
    
    private void dfs(int level, int n, char[][] board, List<List<String>> res) {
        //termination case
        if (level == n) {//found the solution
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                temp.add(String.valueOf(board[i]));
            }
            res.add(temp);
            return;
        }
        //subcase: ensure only one queue per col
        for (int i = 0; i < n; i++) {
            if (!col.contains(i) && !diff.contains(i - level) && !sum.contains(i + level)) {
                col.add(i);
                diff.add(i - level);
                sum.add(i + level);
                board[level][i] = 'Q';
                dfs(level + 1, n, board, res);
                col.remove(i);
                diff.remove(i - level);
                sum.remove(i + level);
                board[level][i] = '.';
            }
        }
    }
}