class Solution {
    public int[] findOrder(int numCourses, int[][] arr) {
     int n= arr.length;
     int V=numCourses;
     ArrayList<ArrayList<Integer>> adj=new ArrayList<>() ;
     int[] ans=new int[V];
     for(int i=0;i<V;i++){
    adj.add(new ArrayList<>());
     }
for(int i=0;i<n;i++) {
    adj.get(arr[i][1]).add(arr[i][0]);
}
//making the indegree
int[] indegree=new int[V];
int[] vis=new int[V];
for(int i=0;i<V;i++){
    for(int it:adj.get(i)){
        indegree[it]++;
    }
}
Queue<Integer> q=new LinkedList<>();
for(int i=0;i<V;i++){
if(indegree[i]==0){
q.add(i);
vis[i]=1;
}
}
int idx=0;
while(!q.isEmpty()){
int node=q.poll();
ans[idx++]=node;
for(int it:adj.get(node)){
    if(vis[it]==0){
    indegree[it]--;
    if(indegree[it]==0){
        q.add(it);
        vis[it]=1;
    }
    }
}
}

return idx==V ? ans : new int[]{};







    }
}