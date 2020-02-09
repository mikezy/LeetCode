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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        //corner case
        if (root == null) return res;
        //use a queue to store the nodes at the same level
        Queue<TreeNode> q = new LinkedList<>();
        //init queue
        q.offer(root);
        //BFS
        //left2right
        boolean left2right = true;
        while (!q.isEmpty()) {
            int qSize = q.size();
            List<Integer> level = new LinkedList<>();
            //loop through the level
            for (int i = 0; i < qSize; i++) {
                TreeNode cur = q.poll();
                //add value to level
                if (left2right) {
                    level.add(cur.val);    
                } else {
                    level.add(0, cur.val);
                }
                 
                //add left and right child to the queue
                    if (cur.left != null) q.offer(cur.left);  
                    if (cur.right != null) q.offer(cur.right);
  
                                 
                
            }
                        
            left2right = !left2right;
            res.add(level); //add the level to the head of the queue, so reversed
        }
        return res;

     }
}