class Solution {
    public int maxProduct(int[] nums) {
      int prevMin = nums[0];
      int prevMax = nums[0];
      int max = nums[0];

      
      //for each elem, calculate:
      for (int i = 1; i < nums.length; i++) {
        //elem self, elem* prev min, elem* prev max
        curr = nums[i];
        int currMin = Math.min(Math.min(curr, curr*prevMin),  curr*prevMax);
        int currMax = Math.max(Math.max(curr, curr*prevMin),  curr*prevMax);
        
        if (currMax > max) max = currMax;
        prevMin = currMin;
        prevMax = currMax;
        
        
      }
      
      return max;
      
    }
}