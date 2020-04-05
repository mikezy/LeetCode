class Solution {
    
    public int res;
    HashSet<Integer> col = new HashSet<>(); //only one queue each column
    HashSet<Integer> diff = new HashSet<>(); //only one queue per diag from top left to bottom right
    HashSet<Integer> sum = new HashSet<>(); //only one queue per diag from top right to bottom left
    
    public int totalNQueens(int n) {
        //corner case
        if (n <= 0) return res;
        dfs(0, n);
        return res;
        
    }
    
    private void dfs(int level, int n) {
        //termination case  
        if (level == n) {//found the solution   
            res++;
            return;
        }
        //subcase: ensure only one queue per row
        for (int row = 0; row < n; row++) {
            if (!col.contains(row) && !diff.contains(row - level) && !sum.contains(row + level)) {
                col.add(row);
                diff.add(row - level);
                sum.add(row + level);
                dfs(level + 1, n);
                col.remove(row);
                diff.remove(row - level);
                sum.remove(row + level);
            }
        }
    }
}