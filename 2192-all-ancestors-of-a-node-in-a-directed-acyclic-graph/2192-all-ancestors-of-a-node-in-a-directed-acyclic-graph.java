class Solution {
    public void dfs(int ancestor,int node,List<List<Integer>> adj,List<List<Integer>> res){
    for(int neigh:adj.get(node)){
  if(res.get(neigh).isEmpty() || res.get(neigh).get(res.get(neigh).size()-1)!=ancestor) {
res.get(neigh).add(ancestor);
dfs(ancestor,neigh,adj,res);
  }
    }
    }
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
     //the nodes to which it is going then particualr node will become ancestor of that node
     List<List<Integer>> adj=new ArrayList<>();
     for(int i=0;i<n;i++) {
        adj.add(new ArrayList<>());
     }  
 List<List<Integer>> res=new ArrayList<>();
  for(int i=0;i<n;i++) {
        res.add(new ArrayList<>());
     }
for(int[] a:edges){
adj.get(a[0]).add(a[1]);
}
//checking out nodes for which the particuar node can be ancestor
for(int i=0;i<n;i++){
dfs(i,i,adj,res);
}
return res;

    }
}