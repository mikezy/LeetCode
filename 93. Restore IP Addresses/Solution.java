class Solution {
    public List<String> restoreIpAddresses(String s) {
        //ip address has 4 sections
        //each section [0. 255]
        //length is [4.12]
        //corner case
        List<String> res = new ArrayList<>();
        if (s.length() <4 || s.length() >12) return res;
        dfs(res, s, "", 0);
        return res;
    }
    //s is what left to be processed
    //sub is what has been processed
    //index is the # of section
    private void dfs(List<String> res, String s, String sub, int index) {
        //termination case
        //return the sub string from position 1, because sub is .xxx.xxx.xxx.xx
        if (index == 4 && s.length() == 0) res.add(sub.substring(1));
        if (index == 4 || s.length() == 0) return; //res not legit
        
        //subcase
        //1 digit
        dfs(res, s.substring(1), sub + '.' + s.substring(0, 1), index + 1);
        //2 digit
        if (s.charAt(0) != '0' && s.length() > 1) { //'01' is not legit
            dfs(res, s.substring(2), sub + '.' + s.substring(0, 2), index + 1);
            //3 digit
            if (s.length() > 2 && Integer.valueOf(s.substring(0, 3)) <= 255) {
                dfs(res, s.substring(3), sub + '.' + s.substring(0, 3), index + 1);
            }
        }
        
    }
}