class Solution {
private int timer=1;
 public void dfs(int node,int parent,int[] vis,int[] time,int[] low,List<List<Integer>> adj, List<List<Integer>> ans) {
  vis[node]=1;
  time[node]=low[node]=timer++;
  //visiting the neighbour 
  for(int it:adj.get(node)) {
  if(it==parent) continue;
  if(vis[it]==0){
  dfs(it,node,vis, time,low,adj,ans);
  //after performing dfs before backtracking update low of node
 low[node]=Math.min(low[node],low[it]);
 //checking bridge condition node->it 
 if(low[it]>time[node]) {
 // means node can't be reached anyhow by adjacent node so it is bridge
 ans.add(Arrays.asList(node,it));
 }}
 else {
 //it is alteady visit update low.
 low[node]=Math.min(low[node],low[it]);
 }}
}
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj=new ArrayList<>();
for(int i=0;i<n;i++){
 adj.add(new ArrayList<>());
}
int m=connections.size();
//making adjacency list
for(int i=0;i<m;i++){
int u=connections.get(i).get(0);
int v=connections.get(i).get(1);
adj.get(u).add(v);
adj.get(v).add(u);
}
//performing the dfs
int[] vis=new int[n];
int[] time=new int[n];
int[] low=new int[n];
List<List<Integer>> ans=new ArrayList<>();
dfs(0,-1,vis,time,low,adj,ans);
return ans;
    }
}