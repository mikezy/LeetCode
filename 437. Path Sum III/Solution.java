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

//     public int pathSum(TreeNode root, int sum) {
//         //corner case
//         if (root == null) return 0;
//         //root + left + right
//         return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        
//     }
    
//     private int dfs (TreeNode root, int sum) {
//         //termination case
//         if (root == null) return 0;
//         sum -= root.val;
//         //root + left + right
//         return (sum == 0 ? 1 : 0) + dfs(root.left, sum) + dfs(root.right, sum);
//     }
    
    // Don't understand the algo below
    int count = 0;
    Map<Integer, Integer> map = new HashMap<>();   

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return count;
        }
        doPathSum(root, sum, 0);
        return count;
    }

    public void doPathSum(TreeNode root, int sum, int pathSum) {
        pathSum += root.val;  //pathSum = The sum of val from root to current node
        if (pathSum == sum) {
            count++;
        }
        count += map.getOrDefault(pathSum-sum, 0); //any subpath = pathSum - Sum
        map.put(pathSum, map.getOrDefault(pathSum, 0)+1);
        if (root.left != null) {
            doPathSum(root.left, sum, pathSum);
        }
        if (root.right != null) {
            doPathSum(root.right, sum, pathSum);
        }
        map.put(pathSum, map.get(pathSum) - 1);
    }
}