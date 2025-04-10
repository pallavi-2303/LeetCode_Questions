class Solution {
private int timer=1;
    public void dfs(int node,int parent,List<List<Integer>> adj,int[] vis,List<List<Integer>> ans,int[] time,int[] low ){
vis[node]=1;
low[node]=time[node]=timer++;
//Now visting all the  nodes
for(int it:adj.get(node)){
if(it==parent) continue;
if(vis[it]==0){
//perform the dfs
dfs(it,node,adj,vis,ans,time,low);
//after dfs of current node it done
low[node]=Math.min(low[node],low[it]);
//checking the conditio for bridge
if(low[it]>time[node]){
//this adjacentt node cant reach the current nnode via any of  its neghbour means it is not connected
//node--it
ans.add(Arrays.asList(node,it));
}
}
else {
//if adjacent node it alreaddy visited
low[node]=Math.min(low[node],low[it]);
}}
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
     //first we will make adjacency list of graph
      //Making of adjacency list 
List<List<Integer>> adj=new ArrayList<>();
for(int i=0;i<n;i++){
 adj.add(new ArrayList<>());
}
for(List<Integer> it:connections){
int u=it.get(0);
int v=it.get(1);
adj.get(u).add(v);
adj.get(v).add(u);
}
List<List<Integer>> ans=new ArrayList<>(); 
int[] time=new int[n];
int[] low=new int[n];
int[] vis=new int[n];
//performing the dfsto find the bridges in graph
dfs(0,-1,adj,vis,ans,time,low);
return ans;

    }
}