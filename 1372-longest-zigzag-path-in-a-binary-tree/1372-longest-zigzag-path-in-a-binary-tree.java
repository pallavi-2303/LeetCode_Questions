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
    //since we have to track longest path we have to calculate the path at every node
public class VisitedNode{
TreeNode node;
int path;
boolean prevRight;
public VisitedNode(TreeNode node,int path,boolean prevRight){
this.node=node;
this.path=path;
this.prevRight=prevRight;}}
    public int longestZigZag(TreeNode root) {
        if(root==null) return 0;
int maxi=0;
Queue<VisitedNode> q=new LinkedList<>();
if(root.left!=null){
q.add(new VisitedNode(root.left,1,false));}
if(root.right!=null){
q.add(new VisitedNode(root.right,1,true));}
while(!q.isEmpty()){
VisitedNode curr=q.poll();
maxi=Math.max(maxi,curr.path);
if(curr.node.left!=null){
if(curr.prevRight){
q.add(new VisitedNode(curr.node.left,curr.path+1,false));}
else{
q.add(new VisitedNode(curr.node.left,1,false));}
}
if(curr.node.right!=null){
if(curr.prevRight){
q.add(new VisitedNode(curr.node.right,1,true));}
else{
q.add(new VisitedNode(curr.node.right,curr.path+1,true));}}
}
return maxi;
    }
}