class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        //corner case
        if (nums == null || nums.length ==0) return null;
        
        
        if (nums.length == 1) {
            List<Integer> list = new ArrayList<>(1);
            list.add(nums[0]);
            return list;
        }
        //usd HashMap to store <unique element, freq>
        HashMap<Integer, Integer> map = new HashMap<>();
        
        //sort the array and put into the Hashmap
        Arrays.sort(nums);
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                map.put(nums[i-1], count);
                count = 0;
            }
            count++;
            map.put(nums[i], count);
        }
        //iterate Hashmap to create an array then sort
        int[][] res = new int[map.size()][2];
        
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res[index][1] = entry.getKey();
            res[index][0] = entry.getValue();
            index++;
        }
        
        Arrays.sort(res, (a, b) -> {return b[0] - a[0];});
        
        //output the top k element
        List<Integer> ans = new LinkedList();
        int j = 0;
        while (j < k) {
            ans.add(res[j][1]);
            j++;
        }
        return ans;
    }
}