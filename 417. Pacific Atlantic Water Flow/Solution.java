class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {

        List<List<Integer>> res = new ArrayList<>();
        //corner case
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        
        boolean[][] pacific = new boolean[matrix.length][matrix[0].length];
        boolean[][] atlantic = new boolean[matrix.length][matrix[0].length];
        
        //top and bottom
        for (int col = 0; col < matrix[0].length; col++) {
            dfs(matrix, 0, col, Integer.MIN_VALUE, pacific); //top
            dfs(matrix, matrix.length - 1, col, Integer.MIN_VALUE, atlantic); //bottom
        }
        //left and right
        for (int row = 0; row < matrix.length; row++) {
            dfs(matrix, row, 0, Integer.MIN_VALUE, pacific); //top
            dfs(matrix, row, matrix[0].length - 1, Integer.MIN_VALUE, atlantic); //bottom
        }
        
        //iteration and compare
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (pacific[i][j] == true && atlantic[i][j] == true) {
                    List<Integer> temp = new ArrayList<>();
                    temp.addAll(Arrays.asList(i, j)); //[i, j]
                    res.add(temp);
                }
            }
        }
        
        return res;
    }
    
    private void dfs(int[][] matrix, int row, int col, int preHeight, boolean[][] ocean) {
        //1. stop conditions
        //boundary
        if (row < 0 || row > matrix.length - 1|| col < 0 || col > matrix[0].length - 1) return;
        //cannot flow: curHeight < preHeight
        else if (matrix[row][col] < preHeight) return;
        //visited
        else if (ocean[row][col] == true) return;
        //2. process cell
        ocean[row][col] = true;
        //3. dfs neighbours
        dfs(matrix, row + 1, col, matrix[row][col], ocean);
        dfs(matrix, row - 1, col, matrix[row][col], ocean);
        dfs(matrix, row, col + 1, matrix[row][col], ocean);
        dfs(matrix, row, col - 1, matrix[row][col], ocean);
    }
}