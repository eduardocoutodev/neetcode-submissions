/*
Definition for a Node.
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
    record NodeToClone(Node original, Node cloneNode){}

    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }

        HashMap<Node, Node> map = new HashMap<>();
        Deque<NodeToClone> queue = new ArrayDeque<>();
        
        Node cloneRoot = new Node(node.val);
        queue.addLast(new NodeToClone(node, cloneRoot));
        map.put(node, cloneRoot);

        while(!queue.isEmpty()){
            int nodesToProcess = queue.size();

            for(int i = 0; i < nodesToProcess; i++){
                NodeToClone nodeToClone = queue.removeFirst();
                for(Node neighboor: nodeToClone.original.neighbors){
                    Node cloneNeighboor;
                    if(!map.containsKey(neighboor)){
                        cloneNeighboor = new Node(neighboor.val);
                        map.put(neighboor, cloneNeighboor);
                        queue.addLast(new NodeToClone(neighboor, cloneNeighboor));
                    }

                    cloneNeighboor = map.get(neighboor);
                    nodeToClone.cloneNode.neighbors.add(cloneNeighboor);
                }
            }
        }

        return cloneRoot;
    }
}