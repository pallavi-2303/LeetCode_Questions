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
    public void dfs(Node curr,Node clone,HashMap<Node,Node> mp){
    //traverse all the adjacennt nodes and make clone node
    //visist  te neightnours of given node
    for(Node neigh:curr.neighbors){
    //if this neigh node  if not present  just clone its neightbous add clone node neighbour and put in map
    if(!mp.containsKey(neigh)){
    Node cloneNode=new Node(neigh.val);
    mp.put(neigh,cloneNode);
    clone.neighbors.add(cloneNode);
    //call dfs for neighnode
    dfs(neigh,cloneNode,mp);
    }
    else {
    //if node is laready present just add its nneighbour
        clone.neighbors.add(mp.get(neigh));
    }
    }
    }
    public Node cloneGraph(Node node) {
     if(node==null)  return null;
    //use a map to store node and its clone
    HashMap<Node,Node> mp=new HashMap<>();
    Node clone=new Node(node.val);
    mp.put(node,clone);
    dfs(node,clone,mp);
    return clone;
    }
}