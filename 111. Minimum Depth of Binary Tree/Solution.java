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
    public int minDepth(TreeNode root) {
        //corner case
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        //init queue
        Queue <TreeNode> queue = new LinkedList<>(); 
        queue.offer(root);
        //BFS
        int min = 0;
        while (queue != null) {
            //array to store all nodes at the same level
            List<TreeNode> level = new ArrayList<>();
            int qSize = queue.size();
            min++;
            for (int i = 0; i < qSize; i++) {
                TreeNode cur = queue.poll();
                if (cur.left == null && cur.right == null) {
                    return min;
                } else {
                    if (cur.left != null) queue.offer(cur.left);
                    if (cur.right != null) queue.offer(cur.right);
                }
                
            }
        }
        return min;
    }
}