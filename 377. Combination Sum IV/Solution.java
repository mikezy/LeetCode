class Solution {

//     public int combinationSum4(int[] nums, int target) {
//         //corner case
//         if (nums == null || nums.length == 0) return 0;
//         //use a dp array to record the calculated res
//         int[] dp = new int[target + 1];
//         dp[0] = 1;
//         return dfs(nums, target, dp);
       
//     }
    
//     private int dfs(int[] nums, int target, int[] dp) {
//         //termination case

//         if (target == 0) {
//             return 1;
//         }
//         if (target < 0) return 0;
//         if (dp[target] > 0) return dp[target];
//         //search
//         int res = 0;
//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] > target) continue;
//             res += dfs(nums, target - nums[i], dp);
//         }
//         dp[target] = res;
//         return res;
//     }
    
    //DFS and memization exceeded time limit
    //Have to use DP
    public int combinationSum4(int[] nums, int target) {
        //corner case
        if (nums == null || nums.length == 0) return 0;
        //init dp array
        int[] dp = new int[target + 1];
        dp[0] = 1;
        //calc dp[1..target]
        for (int i = 1; i <= target; i++) {
            for (int k = 0; k < nums.length; k++) {
                if (nums[k] > i) continue;
                dp[i] += dp[i - nums[k]];
            }
        }
        
        return dp[target];
    }
     
    
}