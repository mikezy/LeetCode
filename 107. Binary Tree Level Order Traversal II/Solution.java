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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        //corner case
        if (root == null) return res;
        //use a queue to store the nodes at the same level
        Queue<TreeNode> q = new LinkedList<>();
        //init queue
        q.offer(root);
        //BFS
        while (!q.isEmpty()) {
            int qSize = q.size();
            List<Integer> level = new LinkedList<>();
            //loop through the level
            for (int i = 0; i < qSize; i++) {
                TreeNode cur = q.poll();
                level.add(cur.val); //add value to level
                //add left and right child to the queue
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
                
            }
            res.add(0, level); //add the level to the head of the queue, so reversed
        }
        return res;
    }
}