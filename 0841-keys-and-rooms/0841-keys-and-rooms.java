class Solution {
    public void dfs(int node,int[] vis,List<List<Integer>> room){
vis[node]=1;
for(int roomkey:room.get(node)) {
if(vis[roomkey]!=1){
dfs(roomkey,vis,room);
}
}
}
public void bfs(int i,int[] vis,List<List<Integer>> rooms){
Queue<Integer> q=new LinkedList<>();
q.add(i);
vis[i]=1;
while(!q.isEmpty()){
int node=q.poll();
for(int it:rooms.get(node)){
if(vis[it]==0){
vis[it]=1;
q.add(it);
}
}
}
}
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
       int n=rooms.size();
int[] vis=new int[n];
//dfs(0,vis,rooms);
bfs(0,vis,rooms);
for(int i=0;i<n;i++){
if(vis[i]==0) return false;
}
return true; 
    }
}