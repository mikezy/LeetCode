class Solution {
    public int[][] merge(int[][] intervals) {
        
        
        //if input is null or length <=1, return 
        if (intervals == null || intervals.length <= 1) return intervals;
        //sort the interval
        Arrays.sort(intervals, (int[] a, int[] b) -> {
            return a[0] - b[0];
        });
        
        //two pointers: prev and curr      
        //result list
        int[] prev = intervals[0];
        List<int[]> res = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            
            int[] curr = intervals[i];
            //overlap
            if (curr[0] <= prev[1]) {
                curr[0] = prev[0];
                curr[1] = Math.max(prev[1], curr[1]);    
            }
            //no overlap
            else {
                //put prev into result
                res.add(prev);
               
            }
             //prev = curr
            prev = curr;
        }
        res.add(prev);
        
         return res.toArray(new int[res.size()][2]);
        
    }
}