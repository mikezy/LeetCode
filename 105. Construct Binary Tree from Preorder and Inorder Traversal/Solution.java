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
    
    //use hashmap to store the inorder array
    HashMap<Integer, Integer> map = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = helper(0, preorder.length - 1, 0, inorder.length - 1, preorder);
        return root;
        
    }
    
    public TreeNode helper(int preStart, int preEnd, int inStart, int inEnd, int[] preorder) {
        //traverse termination
        if (preStart > preEnd || inStart > inEnd) return null;
        
        //get the root from preorder
        TreeNode root = new TreeNode(preorder[preStart]);
        //get the location of root in inorder
        int inRoot = map.get(root.val);
        //num of left
        int numLeft = inRoot - inStart;
        //link left and right
        root.left = helper(preStart+1, preStart+numLeft, inStart, inRoot-1, preorder);
        root.right = helper(preStart+1+numLeft, preEnd, inRoot+1, inEnd, preorder);
        
        
        return root;
    }

}