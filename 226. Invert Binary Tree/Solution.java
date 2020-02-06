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
    public TreeNode invertTree(TreeNode root) {
        //corner case
        if (root == null) return root;
        //traverse
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        //do stuff
        root.left = right;
        root.right = left;
        return root;
    }
    
   
    
}