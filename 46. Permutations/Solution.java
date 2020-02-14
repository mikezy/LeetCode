class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        //dfs
        dfs(nums, new boolean[nums.length], new ArrayList<Integer>(), res);
        return res;
    }
    
    private void dfs(int[] nums, boolean[] visited, List<Integer> subset, List<List<Integer>> res) {
        //termination case
        if (subset.size() == nums.length) {
            res.add(new ArrayList<Integer>(subset));
            return;
        }
        //loop
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            subset.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, subset, res);
            subset.remove(subset.size() - 1);
            visited[i] = false;
        }
    }
}

  //               []
  //   [1]         [2]         [3]
  // [1,2][1,3]  [2,1][2,3]    [3,1][3,2]