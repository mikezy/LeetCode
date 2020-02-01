class Solution {
    public int search(int[] nums, int target) {
      if (nums == null || nums.length == 0) return -1; 
      //binary search
      int start = 0;
      int end = nums.length-1;
      
      while (start +1 < end) {
        int mid = (end - start)/2 + start;
        if (nums[mid] == target) return mid;
        //4 5 6 7 0 1 2
        if (nums[start] < nums[mid]) {
          if (nums[start] <= target && target <= nums[mid]) {
            end = mid;
          } else start = mid;
        } else { //4 5 6 0 1 2 3
          if (nums[mid] <= target && target <= nums[end]) {
            start = mid;
          } else end = mid;
        }
        
      }
      
      if (nums[start] == target) return start;
      if (nums[end] == target) return end;
      return -1;
     
      
    }
}