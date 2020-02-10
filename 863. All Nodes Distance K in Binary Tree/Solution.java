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
    Map<TreeNode, List<TreeNode>> map = new HashMap<>();
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        
        List<Integer> res = new ArrayList<>();
        //corner case
        if (K < 0) return res;
        //build graph
        buildGraph(root, null);
        //BFS starting from target node
        Queue <TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        q.offer(target); //traverse from target
        visited.add(target);
        
        while (!q.isEmpty()) {
            int size = q.size();
            //arrive at the K level
            if (K == 0) {
                for (int i = 0; i < size; i++) {
                    TreeNode cur = q.poll();
                    res.add(cur.val);
                    
                }
                return res;
            }
                //on the way to K level
                //add all neightbours to q
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                for (TreeNode nei: map.get(cur)) {
                    if (visited.contains(nei)) {
                        continue;
                    }
                    q.offer(nei);
                    visited.add(nei);
                }
            }
            K--;    
        }
            
        
        return res;
    }
    
    public void buildGraph (TreeNode node, TreeNode parent) {
        //termination case
        if (node == null) return;
        //if node is not in the graph
        if (!map.containsKey(node)) {
            //add parent node
            map.put(node, new ArrayList<TreeNode>());
            if (parent != null) {
                map.get(node).add(parent);
                //if (node.left != null) map.get(node).add(node.left);
                //if (node.right != null) map.get(node).add(node.right);
                map.get(parent).add(node);
            }
            //DFS left and right
            buildGraph(node.left, node);
            buildGraph(node.right, node);
        }
    }
}