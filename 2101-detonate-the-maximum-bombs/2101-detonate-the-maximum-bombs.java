class Solution {
    public void dfs(int node,HashSet<Integer> vis,List<List<Integer>> adj){
vis.add(node);
for(int it:adj.get(node)){
if(!vis.contains(it)){
dfs(it,vis,adj);}}}

public int bfs(int u,List<List<Integer>> adj){
Queue<Integer> q=new LinkedList<>();
q.add(u);
HashSet<Integer> st=new HashSet<>();
st.add(u);
while(!q.isEmpty()){
int node=q.poll();
for(int it:adj.get(node)){
if(!st.contains(it)){
st.add(it);
q.add(it);}}
}
return st.size();}
    public int maximumDetonation(int[][] bombs) {
      //Since we have to diffuse the bomb and one can diffuse other only if comes into the boundary of other 
int n=bombs.length;
List<List<Integer>> adj=new ArrayList<>();
for(int i=0;i<n;i++){
adj.add(new ArrayList<>());}
//For storing unique bombs if it can diffuse 

//Making the adjacency list
for(int i=0;i<n;i++){
//Can uth bomb come it the range of another from i to n
for(int j=0;j<n;j++){
if(i==j) continue;
int x1=bombs[i][0];
int y1=bombs[i][1];
int r1=bombs[i][2];
int x2=bombs[j][0];
int y2=bombs[j][1];
int r2=bombs[j][2];
long x=(long)(x2-x1);
long y=(long)(y2-y1);
long dis=x*x+y*y;
if((long)(r1*r1)>=dis){
adj.get(i).add(j);}}}
int result=0;
//try to do dfs with every node to find out the number of node;
for(int i=0;i<n;i++){
HashSet<Integer> vis=new HashSet<>();
dfs(i,vis,adj);
//int count= bfs(i,adj);
//result=Math.max(result,count);
result=Math.max(result,vis.size());
}
//}
return result;  
    }
}