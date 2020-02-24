class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        //corner case
        if (candidates == null || candidates.length == 0) return res;
        //sort candidates
        Arrays.sort(candidates);
        
        dfs(candidates, target, 0, res, new ArrayList<>());
         
        return res;
    }
    
    private void dfs(int[] candidates, int target, int index, List<List<Integer>> res, List<Integer> subset) {
        //termination cases 
        if (target == 0) {//found: add to res, return;
            res.add(new ArrayList<Integer>(subset));//need to copy subset
            return;    
        }
        if (target < 0) {//stop dfs, return
            return;            
        }
        //loop through elems in candidates
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) continue;//green tea
            subset.add(candidates[i]);//stack push
            dfs(candidates, target - candidates[i], i + 1, res, subset);//i+1: elem only use once
            subset.remove(subset.size() - 1);//stack pop
        }
    }
}