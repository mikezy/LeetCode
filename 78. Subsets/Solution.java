class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //corner case
        if (nums == null || nums.length == 0) return res;
        for (int k = 0; k < nums.length+1; k++) {
            dfs(nums, k, 0, new ArrayList<Integer>(), res);    
        }
        
        return res;
    }
    
    private void dfs(int[] nums, int k, int index, List<Integer> subset, List<List<Integer>> res) {
        //termination case  
        if (subset.size() == k) {
            res.add(new ArrayList<Integer>(subset));
            return;
        }
        //loop
        for (int i = index; i < nums.length; i++) {
            subset.add(nums[i]);
            dfs(nums, k, i + 1, subset, res);
            subset.remove(subset.size() - 1);
        }
    }
}