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
    public void findPathSum(TreeNode root, HashMap<Long,Integer> mp,int target,int[] count,long currsum) {
    if(root==null) return;
currsum+=root.val;
if(mp.containsKey(currsum-target)){
count[0]+=mp.get(currsum-target);
}
mp.put(currsum,mp.getOrDefault(currsum,0)+1);
findPathSum(root.left,mp,target,count,currsum);
findPathSum(root.right,mp,target,count,currsum);
mp.put(currsum,mp.get(currsum)-1);
 }
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) {
return 0;
 }
 HashMap<Long,Integer> mp=new HashMap<>();
 int[] count={0};
 mp.put(0L,1);
 findPathSum(root,mp,targetSum,count,0L);
 return count[0];
    }
}