class Solution {
    public List<String> letterCombinations(String digits) {
//         String[] d = new String[]{" ", 
//                                 "", 
//                                 "abc", 
//                                 "def",
//                                 "ghi",
//                                 "jkl",
//                                 "mno",
//                                 "pqrs",
//                                 "tuv",
//                                 "wxyz"};        
//       char[] cur = new char[digits.length()];
//       List<String> ans = new ArrayList<>();
//       if (digits == null || digits.length() == 0) return ans; 
//       dfs(digits, d, 0, cur, ans);
//       return ans;
//     }
    
//     private void dfs (String digits, String[] d, int l, char[] cur, List<String> ans) {
//         //termination case
//         if (l == digits.length()) {
//             ans.add(new String(cur));//make a copy
//             return;
//         }
//         //get the String from d[]
//         String s = d[Character.getNumericValue(digits.charAt(l))];
//         //loop through s
//         for (int i = 0; i < s.length(); i++) {
//             cur[l] = s.charAt(i);
//             dfs(digits, d, l + 1, cur, ans);
//         }
        
        //BFS, slower
              if (digits.length() == 0) return new ArrayList<String>();
      
      String[] d = new String[]{" ", 
                                "", 
                                "abc", 
                                "def",
                                "ghi",
                                "jkl",
                                "mno",
                                "pqrs",
                                "tuv",
                                "wxyz"};       
      List<String> ans = new ArrayList<>();
      ans.add("");
      for (char digit : digits.toCharArray()) {
        List<String> tmp = new ArrayList<>();
        for (String t : ans) {
          String s = d[Character.getNumericValue(digit)];
          for (int i = 0; i < s.length(); ++i)
            tmp.add(t + s.charAt(i));
        }
        ans = tmp;
      }
      
      return ans;
    
    }
}