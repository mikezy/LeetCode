class Solution {
    public int maxSubArray(int[] nums) {
        
        //f[i] = f[i-1] >0 ? f[i-1] + nums[i] ? nums[i]
        int[] f= new int[nums.length]; 
        f[0] = nums[0];
        int max = f[0];
        for (int i = 1; i < nums.length; i++) {
            f[i] = Math.max(f[i-1] + nums[i], nums[i]);
            if (f[i] > max) max = f[i];
                
        }
        
        return max;
    }
}