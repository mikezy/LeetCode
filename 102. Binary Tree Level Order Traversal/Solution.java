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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        // corner case
        if (root == null) return res;
        //use a queue to store nodes on the same level
        Queue<TreeNode> q = new LinkedList<>();
        //init q
        q.offer(root);
        //BFS
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            //loop through the same level
            for (int i = 0; i < size; i++) {
                TreeNode head = q.poll();
                level.add(head.val);
                //add left and right to the q
                if (head.left != null) q.offer(head.left);
                if (head.right != null) q.offer(head.right);
            }
            //add level to res
            res.add(level);
        }
        
        return res;
    }
}