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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        //corner case
        if (root == null) return res;
        //init Q
        Queue <TreeNode> q = new LinkedList<>();
        q.offer(root);
        //BFS
        while (!q.isEmpty()) {
            Double levelSum = 0.00;
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode cur = q.poll();
                levelSum += cur.val;
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
            res.add(levelSum/qSize);
        }
        return res;
    }
}