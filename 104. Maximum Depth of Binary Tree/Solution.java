/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        //corner case
        if (root == null) return 0;
        //init count
        int cnt = 1;
        cnt = dfs(root, cnt);
        
        return cnt;
    }
    
    private int dfs(TreeNode root, int cnt) {
        //termination case
        if (root.left == null && root.right == null) {
            return cnt;
        } else {
            cnt++;
            int left = root.left == null ? 0 : dfs(root.left, cnt);
            int right = root.right == null ? 0 : dfs(root.right,cnt);
            return Math.max(left, right);
        }
        
    }
}