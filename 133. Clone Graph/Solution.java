/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
class Solution {
    //use hashmap to store the <curNode, newNode>
    Map<Node, Node> map = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        //corner case
        if (node == null) return node;
        
        return dfs(node);
        
    }
    
    public Node dfs(Node node) {
        //termination case
        if (node == null) return node;
        //node is found, return the cloned new node
        if(map.containsKey(node)) {
            return map.get(node);
        } else {
            //node not found, clone the node to a new node
            Node newNode = new Node(node.val); //copy the value first
            map.put(node, newNode);
            //copy all the edges
            List<Node> list = new ArrayList<>();
            for (Node nb: node.neighbors) {
                list.add(dfs(nb));
            }
            newNode.neighbors = list;
            return newNode;
        }  
        
    }
}