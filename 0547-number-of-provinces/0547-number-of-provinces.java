class Solution {
    public void dfs(int node,int[] vis,List<List<Integer>> adj){
vis[node]=1;
for(int it:adj.get(node)){
if(vis[it]==0){
dfs(it,vis,adj);
}
}
}
    public int findCircleNum(int[][] isConnected) {
        int V=isConnected.length;
List<List<Integer>> adj=new ArrayList<>();
for(int i=0;i<V;i++){
adj.add(new ArrayList<>());
}
for(int i=0;i<V;i++){
for(int j=0;j<V;j++){
if(isConnected[i][j]==1 && i!=j ) {
adj.get(i).add(j);
adj.get(j).add(i);}}}
int[] vis=new int[V];
int count=0;
for(int i=0;i<V;i++){
if(vis[i]==0){
count++;
dfs(i,vis,adj);
}
}
return count;
    }
}