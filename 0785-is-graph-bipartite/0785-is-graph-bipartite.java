class Solution {
    public class pair{
    int node;
    int col;
    public pair(int node,int col){
    this.node=node;
    this.col=col;
    }
    }
    public boolean dfs(int node,int[] color,int col,int[][]
    adj) {
  //marking the color
  color[node]=col;
for(int it:adj[node]) {
if(color[it]==-1) {
 //if it is not colored
 if(dfs(it,color,1-col,adj)==false){
  return false;
 }
}
else {
//if it is already colored
if(color[it]==color[node]) {
  return false;
}
}
}
return true;//if we are able to color the whole graph
    }
    public boolean bfs(int i,int[] color,int c,int[][]
    adj) {
     Queue<pair> q=new LinkedList<>();
     q.add(new pair(i,c));
     color[i]=c;
     while(!q.isEmpty()) {
     pair pt=q.poll();
     int node=pt.node;
     int col=pt.col;
   for(int it:adj[node]) {
  if(color[it]==-1) {
  color[it]=1-col;
  q.add(new pair(it,color[it]));
  }
  else {
  if(color[it]==color[node]) {
  return false;
  }
  }
   }
    
     }
     return true;
    }
    public boolean isBipartite(int[][] graph) {
      //firstly we perform dfs
    int V=graph.length;
    int[] color=new int[V];
    //we will color it by 0 and 1 
    Arrays.fill(color,-1);
   for(int i=0;i<V;i++){
   if(color[i]==-1) {
 // if(dfs(i,color,0,adj)==false){
 if(bfs(i,color,0,graph)==false) {
   return false; }
  }
   }
   return true;
      
    }
}