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
    public class pair{
    TreeNode node;
    int level;
    public pair(TreeNode node,int level){
    this.node=node;
    this.level=level;
    }
    }
    public int maxLevelSum(TreeNode root) {
        if(root==null) return 0;
Queue<pair> q=new LinkedList<>();
q.add(new pair(root,0));
int maxi=Integer.MIN_VALUE;
int smallestLevel=0;
while(!q.isEmpty()){
int size=q.size();
int sum=0;
int leve=q.peek().level;
for(int i=0;i<size;i++){
pair it =q.poll();
TreeNode node=it.node;
int level=it.level;
sum+=node.val;
if(node.left!=null){
q.add(new pair(node.left,level+1));}
if(node.right!=null){
q.add(new pair(node.right,level+1));}
}
if(sum>maxi){
maxi=sum;
smallestLevel=leve+1;}}
return smallestLevel;
    }
}