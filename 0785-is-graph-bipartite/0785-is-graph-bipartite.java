class Solution {
    public class pair {
int node;
int color;
pair(int node,int color){
this.node=node;
this.color=color;}}
   /* public boolean bfs(int i,int[] col,int[][] adj,int color2){
Queue<pair> q=new LinkedList<>();
q.add(new pair(i,color2));
while(!q.isEmpty()){
pair it=q.poll();
int node=it.node;
int color=it.color;
for(int it:adj[node]){
if(col[it]==-1){
col[it]=1-color;
q.add(new pair(it,col[it]));}
else if(col[it]==col[node]){
return false;}}}
return true;}*/
    public boolean dfs(int node,int[] col,int[][] adj,int color){
col[node]=color;
for(int it:adj[node]){
if(col[it]==-1){
if(dfs(it,col,adj,1-color)==false){
return false;}}
//If it is already colored
else if(col[it]==col[node]){
return false;}}
return true;}
    public boolean isBipartite(int[][] graph) {
    int V=graph.length;
        int[] color=new int[V];
Arrays.fill(color,-1);
for(int i=0;i<V;i++){
if(color[i]==-1){
if(dfs(i,color,graph,0)==false){
return false;}}}
return true;
    }
}