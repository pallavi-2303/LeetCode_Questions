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
     if(root==null) return 0;
    Queue<pair> q=new LinkedList<>();
    //Adding the 0th node at first to reduce the over flow  stuff we will try to subtract the minimum index of each elevel from that node
q.add(new pair(root,0));
int maxi=Integer.MIN_VALUE;
while(!q.isEmpty()){
int size=q.size();
//find the minimum index for that level before doing traversal for thatt lavel
int mini=q.peek().index;
int firstIdx=-1;
int lastIdx=-1;
for(int i=1;i<=size;i++)  {
pair it=q.poll();
TreeNode node=it.node;
int index=it.index;
int currIdx=index-mini;
if(i==1) firstIdx=currIdx;
if(i==size) lastIdx=currIdx;
if(node.left!=null){
    q.add(new pair(node.left,2*currIdx+1));
}
if(node.right!=null){
    q.add(new pair(node.right,2*currIdx+2));
}
}
maxi=Math.max(maxi,lastIdx-firstIdx+1);
}
return maxi;
    }
}