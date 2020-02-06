/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //corner case
        if (root == null) return "";
        //BFS - Queue, DFS - Stack
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        //init q
        q.offer(root);
        //loop
        while(!q.isEmpty()) {
            //poll
            TreeNode cur = q.poll();
            //if null
            if (cur == null) {
                sb.append("null").append(",");
                continue;
            } 
                sb.append(cur.val).append(",");
                 //put left and right nodes into queue
                q.offer(cur.left);
                q.offer(cur.right);
 
        }
        //delete the , after the last element
        sb.deleteCharAt(sb.length() - 1);
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //corner case
        if (data == "") return null;
        //construct a string array
        String[] arr = data.split(",");
        //BFS - Queue
        Queue<TreeNode> q = new LinkedList<>();
        //init queue
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        q.offer(root);
        //loop: 1. create TreeNode 2. link to parent node 3. add to queue
        
        for (int i = 1; i < arr.length; i++) {
            
                TreeNode parent = q.poll();
                //create TreeNode
                if (!arr[i].equals("null")) {
                    parent.left = new TreeNode(Integer.valueOf(arr[i]));
                //link to parent
                //parent.left = left;
                //add to queue
                q.offer(parent.left);
                }
                //right node
                if (!arr[++i].equals("null")) {
                    parent.right = new TreeNode(Integer.valueOf(arr[i]));
                //link to parent
                //parent.right = right;
                //add to queue
                q.offer(parent.right);
                }
            
        }
            
        
        return root;
        
    }

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));