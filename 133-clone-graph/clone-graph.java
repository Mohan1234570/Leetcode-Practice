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
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        HashMap<Node,Node> vis = new HashMap<>();
        return clonedGraph(node,vis);
    }

    public Node clonedGraph(Node node, HashMap<Node,Node> vis){
        if(vis.containsKey(node)){
            return vis.get(node);
        }

        Node clone = new Node(node.val, new ArrayList<>());
        vis.put(node,clone);

        for(Node n : node.neighbors){
            clone.neighbors.add(clonedGraph(n,vis));
        }

        return clone;
    }
}