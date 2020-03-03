class Solution {
    public int lengthOfLongestSubstring(String s) {
//       if (s == null || s.length() == 0) return 0;
//       //sliding window
//       int window_start = 0;
//       int maxLength = 0;
//       int[] charCount = new int[256];//store 0, 1
      
//       for (int window_end = 0; window_end < s.length(); window_end ++) {
//         //expand window
//         charCount[s.charAt(window_end)]++;
        
//         //change window start
//         while (charCount[s.charAt(window_end)] > 1) {//repeated
//           //start poping the start out until no repeat
//           charCount[s.charAt(window_start)]--;
//           window_start++;
//         }
//         maxLength = Math.max(maxLength, window_end - window_start + 1);
        
//       }
        
//       return maxLength;
      
      //sliding window 2    
      if (s == null || s.length() == 0) return 0;
      int res = 0;
      //<char in s, char's latest index>
      HashMap<Character, Integer> map = new HashMap<>();
      
      for (int i = 0, j = 0; j < s.length(); j++) {
        //window left slides to the non j index
        if (map.containsKey(s.charAt(j))) {
          i = Math.max(i, map.get(s.charAt(j)) +1);
          
        }
        //window right ++
        map.put(s.charAt(j), j);
        res = Math.max(res, j - i + 1);
      }
      return res;
    }
}