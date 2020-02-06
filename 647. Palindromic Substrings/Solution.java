class Solution {
    public int countSubstrings(String s) {
      int N = s.length();
      int res = 0;
      
      for (int center = 0; center <= 2*N - 1; center++) {
        int left = center /2;
        int right = left + center % 2;
        while (left >=0 && right < N && s.charAt(left) == s.charAt(right)) {
          res++;
          left--;
          right++;
        }
      }
        return res;
    }
}

//ababa
// 1 letter: 5 ( can be at 1,2,3,4,5)
// 3 letters: 3 (can be at 2,3,4)
// 5 letters: 1 (can be at 3)