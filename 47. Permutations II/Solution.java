class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //corner case
        if (nums == null || nums.length == 0) return res;
        //has green tea, so sort
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) visited[i] = false;
        dfs(nums, visited, new ArrayList<Integer>(), res);
        return res;
    }
    
    private void dfs(int[] nums, boolean[] visited, List<Integer> subset, List<List<Integer>> res) {
        //termination case
        if (subset.size() == nums.length) {
            res.add(new ArrayList<Integer>(subset));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue; //green tea, only pick the first green tea
            subset.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, subset, res);
            subset.remove(subset.size() - 1);
            visited[i] = false;
        }
    }
}