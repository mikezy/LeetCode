class Solution {
    public int findMin(int[] nums) {
      if (nums == null || nums.length == 0) return -1;
      if (nums.length == 1) return nums[0];
      if (nums.length == 2) return Math.min(nums[0], nums[1]);
      
      //l, r, mid
      int l = 0, r = nums.length-1, mid = 0;
      int min = nums[0];
      while (l + 1 < r) {
        mid = (r - l) / 2 + l;
        //4,5,6,7,0,1,2
        if(nums[l] < nums[mid]) {
          //min is in the right sub array
          l = mid;
        } else {
         //5,6,0,1,2,3,4
          r = mid;
        }
        min = Math.min(min, Math.min(Math.min(nums[l], nums[r]), nums[mid]));
        
      }
      return min;  
        
    }
}