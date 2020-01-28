class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        //brute force
        /* for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == nums[i])
                    return true;
            }
        }
        return false;
        */
        
        // Hashset
        Set<Integer> set = new HashSet<>(nums.length);
        
        //insert elem in nums into this hashset, then look back to check whether there is a duplicate
        
        for (int x: nums) {
            
            if (set.contains(x)) return true;
            set.add(x);
        }
        return false;
    }
}