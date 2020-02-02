class Solution {
    public int maxArea(int[] height) {
      
//       //brutal force
//       int max = 0;
//       for (int i = 0; i < height.length -1; i++) {
//         for (int j = i+1; j < height.length; j++) {
          
//             max = Math.max(max, (j-i)* Math.min(height[i] , height[j]));
//         }
//       }
//       return max;  
      
      //two pinters
      int max = 0, l = 0, r = height.length -1;
      while (l < r) {
        max = Math.max(max, Math.min(height[l] , height[r]) * (r - l));
        if (height[l] < height [r]) 
          l++;
        else r--;
      }
      return max;
    }
}