/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public class tuple {
TreeNode node;
int vertical;
int level;
public tuple(TreeNode node,int vertical,int level) {
this.node=node;
this.vertical=vertical;
this.level=level;
}
}
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        //here for each vertical we need a map to store level and for each level we need a priority queue to store nodes of a sungle level in asscending order
TreeMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>> mp=new TreeMap<>();
Queue<tuple> q=new LinkedList<>();
q.add(new tuple(root,0,0));
//performing Level order traversal to store and vertical order of a tree 
while(!q.isEmpty()) {
tuple it=q.poll();
TreeNode node=it.node;
int x=it.vertical;
int y=it.level;
//if for the given vertical TreeMap doesnot exist
if(!mp.containsKey(x)) {
mp.put(x,new TreeMap<>());
}
//if for a given vertical and in a treeMap for the order the priority queuedoesnot exists
if(!mp.get(x).containsKey(y)) {
mp.get(x).put(y,new PriorityQueue<>());
}
//putting the node at correct position 
mp.get(x).get(y).offer(node.val);
if(node.left!=null) {
q.offer(new tuple(node.left,x-1,y+1));
}
if(node.right!=null) {
q.offer(new tuple(node.right,x+1,y+1));
}
}
//after traversal putting the values in list
List<List<Integer>> res=new ArrayList<>();
for(TreeMap<Integer,PriorityQueue<Integer>> ys:mp.values()) {
res.add(new ArrayList<>());
 for(PriorityQueue<Integer> pq:ys.values()) {
 while(!pq.isEmpty()) {
 res.get(res.size()-1).add(pq.poll());
 }
 }
}
return res;
    }
}