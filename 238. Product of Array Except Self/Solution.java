class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        //construct two arrays
        int[] L = new int[nums.length];
        int[] R = new int[nums.length];
        //init 
        L[0] = 1;
        R[nums.length-1] = 1;
        //left array
        for (int i = 1; i < nums.length; i++) {
            
            L[i] = L[i-1] * nums[i-1];
        }
        //right array
        for (int i = nums.length -2; i >=0; i--) {
            R[i] = R[i+1] * nums[i+1];
        }
        //output array
        int[] output = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            output[i] = L[i] * R[i];
        }
        return output;
       
        
    }
}