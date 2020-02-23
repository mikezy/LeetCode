class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        //corner case
        if (candidates == null || candidates.length == 0) return res;
        //dfs
        dfs(candidates, target, 0, res, new ArrayList<>());
        //return
        return res;
    }
    
    private void dfs(int[] candidates, int target, int index, List<List<Integer>> res, List<Integer> subset) {
        //termination case 1, found the List
        if (target == 0) {
            res.add(new ArrayList<Integer>(subset));//add the subset to the res
            return;
        }
        //termination case 2, sum of the sublist > target
        if (target < 0) {
            return; 
        }
        
        //loop through the candidates
        for (int i = index; i < candidates.length; i++) {
            subset.add(candidates[i]);//stack push
            dfs(candidates, target - candidates[i], i, res, subset); //i: use all the elem in candidates, i+1: use the next elem in function
            subset.remove(subset.size() - 1);//stack pop
        }
    }
}