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
    public void RightSideView(TreeNode root,int level,List<Integer> res) {
 if(root==null) 
 return ;
 if(level==res.size()) {
 res.add(root.val);
 }
 RightSideView(root.right,level+1,res);
 RightSideView(root.left,level+1,res);
}
    public List<Integer> rightSideView(TreeNode root) {
     List<Integer> res=new ArrayList<>();
     if(root==null)   return res;
    //  RightSideView(root,0,res);
  //Right Side view means  last nodeof every level 
 Queue<TreeNode> q=new LinkedList<>();
 q.add(root);
 while(!q.isEmpty())  {
int size=q.size();
List<Integer> temp=new ArrayList<>();
for(int i=1;i<=size;i++){
TreeNode node=q.poll();
temp.add(node.val);
if(node.right!=null) q.add(node.right);
if(node.left!=null) q.add(node.left);
}
res.add(temp.get(0));
 }
     return res;
    }
}