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
    
    public int maxPathSum(TreeNode root) {
        int[] max = new int[] {Integer.MIN_VALUE};
        dfs(root, max);
        return max[0];
    }
    
    private int dfs(TreeNode root, int[] max) {
        //calc left and right
        int left = root.left == null ? 0 : Math.max(dfs(root.left, max), 0);//if left is null or left is < 0, use 0
        int right = root.right == null ? 0 : Math.max(dfs(root.right, max), 0);
        int cur = root.val + left + right;
        //update max
        max[0] = Math.max(max[0], cur);
        //return root + the larger value between left and right
        return root.val + Math.max(left, right);
    }
}