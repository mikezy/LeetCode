class Solution {
    public String minWindow(String s, String t) {
      if (t == null || s == null || t.length() == 0 || s.length() == 0) return new String("");
      if (s.length() < t.length()) return new String("");
      //sliding window
      
      int window_start = 0;
      int window_end = 0;
      int minLength = -1;
      int minStart = 0;
      int minEnd = 0;
      
      //get all unique chars and freq in T
  
      HashMap<Character, Integer> mapT = new HashMap<>();
      for(int i = 0; i < t.length(); i++) {
        int count = mapT.getOrDefault(t.charAt(i), 0);
        mapT.put(t.charAt(i), count + 1);
        
      }
      //uniq char in t
      int uniqChar = mapT.size();
      
      HashMap<Character, Integer> windowCount = new HashMap<>();
      int currUniqChar = 0;
  
      while (window_end < s.length()) {
        //add next
        char c = s.charAt(window_end);
        int count = windowCount.getOrDefault(c, 0);
        windowCount.put(c, count+1);
        
        //if the feq of the current char added equals to the count in t then currUniq++
        if(mapT.containsKey(c) && mapT.get(c).intValue() == windowCount.get(c).intValue()) {
          currUniqChar++;
        }
        
        //contract left
        while (window_start <= window_end && currUniqChar == uniqChar) {
          c = s.charAt(window_start);
          //save the smallest window until now
          if (window_end - window_start + 1 < minLength || minLength == -1) {
            minLength = window_end - window_start + 1;
            minStart = window_start;
            minEnd = window_end;
          }
          
          //pop up left
          windowCount.put(c, windowCount.get(c) -1);
          if (mapT.containsKey(c) && windowCount.get(c).intValue() < mapT.get(c).intValue()) {
            currUniqChar--;
          }
          
          window_start++;
          
        }
        //keep expanding
        window_end++;
      }
      
      
      
      return minLength == -1? "" : s.substring(minStart, minEnd+1);
      
    }    
   
}