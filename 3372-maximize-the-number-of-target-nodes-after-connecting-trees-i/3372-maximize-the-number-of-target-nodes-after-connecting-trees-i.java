class Solution {
public List<List<Integer>> makeAdjacency(int[][] edges,int n) {
List<List<Integer>> adj=new ArrayList<>();
for(int i=0;i<n;i++){
adj.add(new ArrayList<>());
}
for(int[] a:edges) {
adj.get(a[0]).add(a[1]);
adj.get(a[1]).add(a[0]);
}
    return adj;
}
public int[] countNodes(List<List<Integer>> adj,int k,int n){
//here we make to count nodes at distance of k
int[] res=new int[n];
//TC->O2(N*(E+N))
//SC->O2(N+E)+O(N)
for(int i=0;i<n;i++){
int[] vis=new int[n];
//res[i]=dfs(i,adj,vis,k);
res[i]=bfs(i,adj,vis,k);
}
    return res;
}
public int dfs(int node,List<List
<Integer>> adj,int[] vis,int k) {
if(k<0) return 0;
//node it self is always an answer
int count=1;
vis[node]=1;
for(int it:adj.get(node)) {
if(vis[it]==0){
count+=dfs(it,adj,vis,k-1);
}
}
return count;
}
public int bfs(int i,List<List<Integer>> adj,int[] vis,int k){
//queue to store node and distance 
Queue<int[]> q=new LinkedList<>();
q.add(new int[]{i,0});
int count=0;
vis[i]=1;
//count all nodes less than rqual to k distance 
while(!q.isEmpty()){
int[] a=q.poll();
int node=a[0];
int dis=a[1];
if(dis>k) continue;
//increase count if its distnave less than equal to k
count++;
for(int it:adj.get(node)){
if(vis[it]==0){
vis[it]=1;
q.add(new int[]{it,dis+1});
}
}
}
return count;
}
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
    //Since we have to one node to anither nodevwe will find the distance at k for each node and for another tree dustance at k-1 and connect all nodes that gives us maximum nodes 
int N1=edges1.length+1;
int N2=edges2.length+1;
//making adjacency List
List<List<Integer>> adj1=makeAdjacency(edges1,N1);
List<List<Integer>> adj2=makeAdjacency(edges2,N2);
//making result to find out yhe number of nodes 
int[] res1=countNodes(adj1,k,N1);
int[] res2=countNodes(adj2,k-1,N2);
int maxi=Arrays.stream(res2).max().getAsInt();
//Finding the maximum 
for(int i=0;i<N1;i++){
res1[i]+=maxi;
}
return res1;

    }
}