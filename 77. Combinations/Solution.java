class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        //corner case
        if (n < 1 || k >  n) return res;
        //dfs
        dfs(n, k, 1, new ArrayList<Integer>(), res);
        return res;
    }
    
    private void dfs(int n, int k, int index, List<Integer> subset, List<List<Integer>> res) {
        //termination case
        if (subset.size() == k) {
            res.add(new ArrayList<Integer>(subset));
            return;
        }
        //loop
        for (int i = index; i <= n; i++) {
            subset.add(i); //stack push
            dfs(n, k, i + 1, subset, res);
            subset.remove(subset.size() - 1); //stack pop
        }
    }
}