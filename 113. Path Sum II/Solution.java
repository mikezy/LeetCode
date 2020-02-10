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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        //corner case
        if (root == null) return res;
        //dfs
        dfs(res, new ArrayList<Integer>(), sum, root);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, List<Integer> path, int sum, TreeNode root) {
        //termination case 1
        if (root == null) return;
        sum -= root.val;
        //termination case 2 -- leaf node
        if (root.left == null && root.right ==null) {
            //at leaf node, compare sum to 0
            if (sum == 0) { //found the path
                path.add(root.val);//stack push
                res.add(new ArrayList<Integer>(path));
                path.remove(path.size() - 1);//stack pop
            }
            //not found, so just return
            return;
        }
        //not at leaf node
        path.add(root.val); //stack push
        dfs(res, path, sum, root.left);
        dfs(res, path, sum, root.right);
        path.remove(path.size() - 1);//stack pop
    }
}