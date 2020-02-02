class Solution {
    public int characterReplacement(String s, int k) {
        //sliding window
      int window_start = 0;
      int[] char_counts = new int[26];
      int maxCharCount = 0;
      int maxLength = 0;
      
      for (int window_end = 0; window_end < s.length(); window_end++) {
        //expand the window
        int currCharCount = ++char_counts[s.charAt(window_end) - 'A'];
        maxCharCount = Math.max(maxCharCount, currCharCount);
        
        while (window_end - window_start - maxCharCount +1 > k) {//change the window start
         //pop the window_start
          char_counts[s.charAt(window_start) - 'A']--;
          window_start++;
          
        }
        maxLength = Math.max(maxLength, window_end - window_start +1);
      }
      
      return maxLength;
    }
}