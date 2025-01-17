class Solution {
    public boolean canFinish(int numCourses, int[][] arr) {
       int V=numCourses;
       ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
       int n=arr.length;
       for(int i=0;i<V;i++){
    adj.add(new ArrayList<>());
       }
       for(int i=0;i<n;i++){
    adj.get(arr[i][1]).add(arr[i][0]);
       }
    //if topological sort is valid then this is possible
    int[] indegree=new int[V];
    int[] vis=new int[V];
    for(int i=0;i<V;i++){
    for(int it:adj.get(i)){
        indegree[it]++;
    }
    }
    Queue<Integer> q=new LinkedList<>();
    //adding in q whose indegree is zero
for(int i=0;i<V;i++){
    if(indegree[i]==0){
        vis[i]=1;
        q.add(i);
    }
}
int count=0;
while(!q.isEmpty()){
int node=q.poll();
count++;
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
return count==V ? true:false;




    }
}