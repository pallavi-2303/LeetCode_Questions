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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
Queue<TreeNode> q=new LinkedList<>();
if(root==null) return res;
q.offer(root);
boolean zigzag=true;
while(!q.isEmpty()) {
int size=q.size();
List<Integer> temp=new ArrayList<>();
for(int i=1;i<=size;i++){
 root=q.poll();
temp.add(root.val);
if(root.left!=null ) {
q.add(root.left);
}
if(root.right!=null) {
q.add(root.right);
}
}
if(zigzag==false) {
Collections.reverse(temp);
}
res.add(temp);
zigzag=!zigzag;
}
return res;
    }
}