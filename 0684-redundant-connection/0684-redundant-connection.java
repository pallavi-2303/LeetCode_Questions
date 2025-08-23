class Solution {
    public boolean dfs(int src,int des,int[] vis,List<List<Integer>> adj){
    vis[src]=1;
    if(src==des) return true;
    for(int it:adj.get(src)){
    if(vis[it]==0){
    if(dfs(it,des,vis,adj)) return true;
    }
    }
    return false;//not found
    }
    public boolean bfs(int src,int des,int[] vis,List<List<Integer>> adj){
    Queue<Integer> q=new LinkedList<>();
    q.add(src);
    vis[src]=1;
    while(!q.isEmpty()){
    int node=q.poll();
    if(node==des) return true;
    for(int it:adj.get(node)){
    if(vis[it]==0){
    vis[it]=1;
    q.add(it);
    }
    }
    }
return false;
    }
    public int[] findRedundantConnection(int[][] edges) {
    //in this we have to remove the last node that is already connected
    int n=edges.length; 
List<List<Integer>> adj=new ArrayList<>();
for(int i=0;i<=n;i++){
adj.add(new ArrayList<>());
}
//treverse on all edges
//Tc(V+E)
for(int[] a:edges){
int u=a[0];
int v=a[1];
int[] vis=new int[n+1];
if(!adj.get(u).isEmpty() && !adj.get(v).isEmpty() && bfs(u,v,vis,adj)){
//if u and v are already conncted then this is last edge that can lead to cycle
return a;
}
adj.get(u).add(v);
adj.get(v).add(u);
}
return new int[]{};

    }
}