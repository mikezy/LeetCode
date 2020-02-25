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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //corner case
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        //two array list to store the two trees
        //compare the two array list
        List<Integer> listP = new ArrayList<>();
        List<Integer> listQ = new ArrayList<>();
        //dfs 
        dfs(p, listP);
        dfs(q, listQ);
        return listP.equals(listQ);
    }
    
    private void dfs(TreeNode root, List<Integer> list) {
        //termination case
        if (root == null) {
            list.add(Integer.MIN_VALUE);
            return;
        } else {
            list.add(root.val);
            dfs(root.left, list);
            dfs(root.right, list);
            return;
        }
    }
    
    //simpler solution
  //   public boolean isSameTree(TreeNode p, TreeNode q) {
  //   // p and q are both null
  //   if (p == null && q == null) return true;
  //   // one of p and q is null
  //   if (q == null || p == null) return false;
  //   if (p.val != q.val) return false;
  //   return isSameTree(p.right, q.right) &&
  //           isSameTree(p.left, q.left);
  // }
}