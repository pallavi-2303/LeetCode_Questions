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
    public void findParent(TreeNode root,HashMap<TreeNode,TreeNode> mp){
    Queue<TreeNode> q=new LinkedList<>();
    q.add(root);
    while(!q.isEmpty()){
    TreeNode node=q.poll();
    if(node.left!=null){
    q.add(node.left);
    mp.put(node.left,node);
    }
    if(node.right!=null){
        mp.put(node.right,node);
        q.add(node.right);
    }
    }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    //so we are making the parent the parent pointer so that we can also go the parent node as it will also be at the same distance as the left and right node and we will also require the visisted array so that we not go the parnet and same node twice as it will not be at kth distance 
//step->1 Creating the parent pointer 
HashMap<TreeNode,TreeNode> parent=new HashMap<>();
findParent(root,parent);
//performing level order traversal to find the all the kth node from the target
Queue<TreeNode> q=new LinkedList<>();
HashMap<TreeNode,Boolean> vis=new HashMap<>();
q.add(target);
vis.put(target,true);
int level=0;
while(!q.isEmpty()){
if(level>=k) break;
int n=q.size();
level++;
for(int i=0;i<n;i++){
//perfoming the level order traversal to find the node at kth distaNCE 
TreeNode node=q.poll();
if(node.left!=null && vis.get(node.left)==null){
q.add(node.left);
vis.put(node.left,true);
}
if(node.right!=null && vis.get(node.right)==null){
q.add(node.right);
vis.put(node.right,true);
}
if(parent.get(node)!=null && vis.get(parent.get(node))==null){
q.add(parent.get(node));
vis.put(parent.get(node),true);
}
}
}
List<Integer> ans=new ArrayList<>();
while(!q.isEmpty()){
TreeNode node=q.poll();
ans.add(node.val);
}
return ans;
    }
}