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
        public void parentTrack(TreeNode root,HashMap<TreeNode,TreeNode> parent){
                Queue<TreeNode> q=new LinkedList<>();
                q.add(root);
                while(!q.isEmpty()){
                TreeNode curr=q.poll();
                        if(curr.left!=null){
                        parent.put(curr.left,curr);
                        q.offer(curr.left);
                        }
                        if(curr.right!=null){
                                parent.put(curr.right,curr);
                                q.offer(curr.right);
                        }
                }
        }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
     //visited node at level k
        //we will do bfs trversalfor each node level wise 
            HashMap<TreeNode,TreeNode> parent=new HashMap<>();
            parentTrack(root,parent);
           int currlevel=0;
            Queue<TreeNode> q=new LinkedList<>();
            //adding the target as we nneed to tracck k ditance  fromthe target
            q.offer(target);
            List<Integer> ans=new ArrayList<>();
            HashMap<TreeNode,Boolean> vis=new HashMap<>();
            vis.put(target,true);
            while(!q.isEmpty()){
             int n=q.size() ;
        if(k==currlevel) break;
                 currlevel++;
        //traversing for given level
                    for(int i=0;i<n;i++){
                TreeNode curr=q.poll();
                if(curr.left!=null && vis.get(curr.left)==null){
                        q.offer(curr.left);
                        vis.put(curr.left,true);
                }
         if(curr.right!=null && vis.get(curr.right)==null){
                                  q.offer(curr.right);
                                    vis.put(curr.right,true);
                            }
                        if(parent.get(curr)!=null && vis.get(parent.get(curr))==null) {
                              vis.put(parent.get(curr),true) ;
                                q.offer(parent.get(curr));
                        }   
                    }
            }
            //after level reaches to k ququw has all nodes at k distance
            while(!q.isEmpty()){
                TreeNode node=q.poll();
                    ans.add(node.val);
            }
            return ans;
    }
}