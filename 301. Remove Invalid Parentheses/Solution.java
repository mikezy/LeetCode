class Solution {
    char[][] patterns = {{'(', ')'}, {')', '('}};
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        //corner case ?
        if (s == null || s.length() == 0) {
            res.add("");
            return res;
        }
        dfs(s, 0, patterns[0], res); //patterns[0] means ( is more than )
        return res;
    }
    
    private void dfs(String s, int lastRemove, char[] pattern, List<String> res) {
        //termination case
        
        //loop
        int cnt = 0;
        int i = 0;
        //()())()
        //i has not reached the end of the string and ) is not more than (
        while (i < s.length() && cnt >= 0) { //patterns[0]
            if (s.charAt(i) == pattern[0]) cnt++; // get (
            if (s.charAt(i) == pattern[1]) cnt--; // get )
            i++;
        }
        //either i reached the end of the string or cnt < 0
        //()()) i = 4
        if (cnt < 0) {
            //remove  one ) from lastRemove to i....0 to 4
            for (int j = lastRemove; j < i; j++) {
                if (s.charAt(j) == pattern[1] && (j == lastRemove || s.charAt(j - 1) != pattern[1])) {
                    dfs(s.substring(0, j) + s.substring(j+1), j, pattern, res); //remove ) at 3
                }
            }
        } else { //i reached the end of the string, meaning ( is more than )
            //reverse s, String is immutable
            String reverse = new StringBuilder(s).reverse().toString();
            if (pattern == patterns[0]) { //patterns[0]
                dfs(reverse, 0, patterns[1], res);
            } else {
                res.add(reverse); // reverse is immutable;
            }
        }
    }
}