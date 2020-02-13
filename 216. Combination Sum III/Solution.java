class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        //corner case
        if (n <= 0 || k <= 0) return res;
        int sum = 0;
        dfs(k, n, 1, res, new ArrayList<Integer>(), sum);
        return res;
    }
    
    private void dfs(int k, int n, int index, List<List<Integer>> res, List<Integer> subset, int sum) {
        //termination case
        if (k == 0 && sum == n) {
            res.add(new ArrayList<Integer>(subset));
            return;
        }
        if (sum > n) return;
        //loop
        for (int i = index; i <= 9; i++) {
            subset.add(i);
            sum += i;
            dfs(k - 1, n, i + 1, res, subset, sum);
            subset.remove(subset.size() - 1);
            sum -= i;
        }
    }
}