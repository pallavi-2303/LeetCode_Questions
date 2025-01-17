class Solution {
    public boolean canFinish(int numCourses, int[][] arr) {
 int V=numCourses;
int n=arr.length;
ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
for(int i=0;i<V;i++){
 adj.add(new ArrayList<>());
}
//making the adjacency list
for(int i=0;i<n;i++){
adj.get(arr[i][1]).add(arr[i][0]);
}
//performing topoSort
int[] indegree=new int[V];
Queue<Integer> q=new LinkedList<>();
for(int i=0;i<V;i++){
 for(int it:adj.get(i)){
 indegree[it]++;}}
//putting in queue whose incoming edge is 0
for(int i=0;i<V;i++){
 if(indegree[i]==0){
 q.add(i);}}
 //performing bfs to get toposort
 int idx=0;
 while(!q.isEmpty()){
 int node=q.poll();
 idx++;
 for(int it:adj.get(node)){
  //removing the node as it is in toposort
  indegree[it]--;
  if(indegree[it]==0){
  q.add(it);}}}
  if(idx==V) return true;
  return false;
        
    }
}