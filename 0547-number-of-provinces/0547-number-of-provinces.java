class Solution {
     public void bfs(int i,int[] vis,ArrayList<ArrayList<Integer>> 
    adj) {
    Queue<Integer> q=new LinkedList<>();
    q.add(i);
    vis[i]=1;
    while(!q.isEmpty()) {
    int node=q.poll();
    for(int it:adj.get(node)) {
    if(vis[it]==0) {
    vis[it]=1;
    q.add(it);}
    }
    }
    }
     public void dfs(int node,int[] vis,ArrayList<ArrayList<Integer>>
  adj) {
   vis[node]=1;
   for(int it:adj.get(node)) {
    if(vis[it]==0) {
    dfs(it,vis,adj);
    }
   }
  }
    public int findCircleNum(int[][] isConnected) {
          ArrayList<ArrayList<Integer>> adjls=new ArrayList<>();
   int V=isConnected.length;
    int[] vis=new int[V];
    for(int i=0;i<V;i++){
   adjls.add(new ArrayList<>());
    }
 for(int i=0;i<V;i++){
  for(int j=0;j<V;j++){
  if(isConnected[i][j]==1 && i!=j){
  //They are connnected
  adjls.get(i).add(j);
  adjls.get(j).add(i);
  }
  }
 }
int count=0;
for(int i=0;i<V;i++){
if(vis[i]==0){
  count++;
  //dfs(i,vis,adjls);
  bfs(i,vis,adjls);
}
}
return count;
    }
}