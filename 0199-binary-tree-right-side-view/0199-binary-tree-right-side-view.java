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
    public List<Integer> rightSideView(TreeNode root) {
     List<Integer> ans=new ArrayList<>();
Queue<TreeNode> q=new LinkedList<>();
if(root==null) return new ArrayList<>();
//right side view means first node  of every level
q.add(root);
while(!q.isEmpty()){
int  size=q.size();
List<Integer> temp=new ArrayList<>();
for(int i=1;i<=size;i++){
TreeNode curr=q.poll();
temp.add(curr.val);
if(curr.right!=null) q.offer(curr.right);
if(curr.left!=null) q.offer(curr.left);
}
ans.add(temp.get(0));
}
return ans;
    }
}