class Solution {
    public int shortestPathLength(int[][] graph) {
        //since we have to track all the paths from where we come from therefore we can use bitmask to track the path 
int n=graph.length;
if(n==0 || n==1) 
return 0;
int allVisitedState=(1<<n)-1;    //(111) 2 ki power n-1 
int[][] vis=new int[n][allVisitedState+1];
Queue<int[]> pq=new LinkedList<>();
//initial add all the starting node
for(int i=0;i<n;i++){
pq.add(new int[]{i,1<<i});
vis[i][(1<<i)]=1;
}
int sortestPath=0;
while(!pq.isEmpty()){
sortestPath++;
int size=pq.size();
for(int i=0;i<size;i++){
int[] curr=pq.poll();
int node=curr[0];
int currMask=curr[1];
//Now visit all the neighbours of node
for(int adj:graph[node]) {
int nextMask=(currMask | (1<<adj));
if(nextMask==allVisitedState){
return sortestPath;
}
if(vis[adj][nextMask]==0){
pq.add(new int[]{adj,nextMask});
vis[adj][nextMask]=1;
}
}
}
}
return sortestPath;
    }
}