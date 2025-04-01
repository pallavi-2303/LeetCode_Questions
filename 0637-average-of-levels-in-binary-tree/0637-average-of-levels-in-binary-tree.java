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
    public List<Double> averageOfLevels(TreeNode root) {
    List<Double> ans=new  ArrayList<>();
    Queue<TreeNode> q=new LinkedList<>();
    if(root==null) return ans;
    q.add(root);
while(!q.isEmpty()){
double sum=0;
int size=q.size();
for(int i=1;i<=size;i++){
root=q.poll();
sum+=root.val;
if(root.left!=null){
q.add(root.left);
}
if(root.right!=null){
q.add(root.right);
}
}
ans.add(sum/(double)size);
}
return ans;  
    }
}