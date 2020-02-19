class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        //corner case
        if (n <= 0) return res;
        dfs(n, n, "", res);
        return res;
    }
    //left is the number of ( yet to be add to the res
    //right is the number of ) yet to be add to the res
    private void dfs(int left, int right, String s, List<String> res) {
        //termination case
        if (left == 0 && right == 0) {
            res.add(s);
            return;
        }
        //subcase
        if (left > 0) { //always add left first
            dfs(left - 1, right, s + '(', res);
        }
        if (left < right && right > 0) { //only when left < right and right >0, add right
            dfs(left, right - 1, s + ')', res);
        }
    }
}



