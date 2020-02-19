class Solution {
    public boolean exist(char[][] board, String word) {
        //similar to the island problem
        //corner case
        if (word == null || word.length() == 0) return true;
        if (board == null || board.length == 0) return false;
        //try to find the first letter in word
        int col = board.length, row = board[0].length;
        for (int y = 0; y < col; y++) {
            for (int x = 0; x < row; x++) {
                if(dfs(board, word, 0, y, x)) return true;
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int index, int i, int j) {
        //termination case
        if (index == word.length()) return true;//found
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index))
            return false;
        //subcase
        board[i][j] = '.';
        boolean res = dfs(board, word, index + 1, i + 1, j) ||
               dfs(board, word, index + 1, i - 1, j) ||
               dfs(board, word, index + 1, i, j + 1) ||
               dfs(board, word, index + 1, i, j - 1);
        board[i][j] = word.charAt(index);//backtracking
        return res;
    }
}