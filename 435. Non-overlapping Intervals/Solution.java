class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //corner case
        if (intervals  == null || intervals.length <= 1) return 0;
//         //sort
//         Arrays.sort(intervals, (a, b) -> {
//             return a[1] - b[1];
//         });
//         //greedy solution 1
//         int ans = 0;
//         for (int i = 0; i < intervals.length; ) {

//             //get right boundary
//             int right = intervals[i][1];
//             int j = i + 1;//next interval
//             //count how many overlap intervals
//             while (j < intervals.length && intervals[j][0] < right) {
//                 j++;
//             }
//             int numOverlapped = j - i;
//             ans += numOverlapped -1; //only need to drop numOverlapped -1
//             //start from j
//             i = j;
//         }
        
//         return ans;
        //greedy solution 2
        // int counter = 0;
        // int slow = 0, fast = 1;// 快慢双指针
        // while (fast < intervals.length) {
        //     if (intervals[slow][0] == intervals[fast][0]) {
        //         // 相同开头的两个间隔元素中只取范围最小者，因为同类必定重叠，范围最小最有机会不与其他元素重叠
        //         // 故放弃当前fast指针指向元素，fast指针后移，计数器+1
        //         counter++;
        //         fast++;
        //     } else if (intervals[slow][1] <= intervals[fast][0]) {
        //         // 不同开头的两个间隔元素，前者尾巴小于后者头部则不相交，满指针移动到fast位置，fast位置后移1
        //         slow = fast;
        //         fast++;
        //     } else if (intervals[slow][1] > intervals[fast][0] &&
        //             intervals[slow][1] < intervals[fast][1]) {
        //         // 不同开头的两个间隔元素，前者尾巴在后者中间，此时前者更有希望不与其他元素重叠，因为更靠前
        //         // 故放弃当前fast指针指向元素，fast指针后移，计数器+1
        //         counter++;
        //         fast++;
        //     } else {
        //         // 不同开头的两个间隔元素，前者尾巴在后者尾巴之后，此时后者更有希望不与其他元素重叠，因为更靠前
        //         // 故放弃slow指针指向的元素，slow指向fast对应元素，fast后移，计数器+1
        //         counter++;
        //         slow = fast;
        //         fast++;
        //     }
        // }
        // return counter;
        //greedy solution 3
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int prevEnd = intervals[0][1];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (prevEnd > intervals[i][0]) {//overlapped
                count++;
                prevEnd = Math.min(intervals[i][1], prevEnd); //keep the smaller inverval
            } else {
                prevEnd = intervals[i][1]; //not overlap, move to right
            }
        }
        return count;
        
    }
}