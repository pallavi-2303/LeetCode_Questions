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
int index;
public pair(TreeNode node,int index){
this.node=node;
this.index=index;
}
}
    public int widthOfBinaryTree(TreeNode root) {
       Queue<pair> q=new LinkedList<>();
if(root==null) return 0;
q.add(new pair(root,0));
int maxi=Integer.MIN_VALUE;
while(!q.isEmpty()) {
int min=q.peek().index;
int firstIdx=-1;
int lastIdx=-1;
int size=q.size();
for(int i=0;i<size;i++){
pair it=q.poll();
int index=it.index;
TreeNode curr=it.node;
int currIdx=index-min;
if(i==0) firstIdx=currIdx;
if(i==size-1) lastIdx=currIdx;
if(curr.left!=null) {
q.add(new pair(curr.left,2*currIdx+1));
}
if(curr.right!=null) {
q.add(new pair(curr.right,2*currIdx+2));
}
maxi=Math.max(maxi,lastIdx-firstIdx+1);
}
}
return maxi; 
    }
}