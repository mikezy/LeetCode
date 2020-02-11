class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        //corner case
        if (nums == null || nums.length == 0) return 0;
        int left = 0; 
        int sum = 0;
        int res = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            //add right elem
            sum += nums[i];
            while (sum >= s) {
                res = Math.min(res, i + 1 - left); //record res
                sum -= nums[left++]; //left moved to right
            }
        }
        
        return res == Integer.MAX_VALUE ? 0 : res;
            
    }
}