class Solution {
    public boolean canFinish(int numCourses, int[][] nums) {
        int n=nums.length;
List<List<Integer>> adj=new ArrayList<>();
int V=numCourses;
for(int i=0;i<V;i++){
adj.add(new ArrayList<>());
}
for(int i=0;i<n;i++){
    adj.get(nums[i][1]).add(nums[i][0]);
}
int[] indegre=new int[V];
Queue<Integer> q=new LinkedList<>();
int[] vis=new int[V];
for(int i=0;i<V;i++){
for(int it:adj.get(i)) {
indegre[it]++;
}
}
for(int i=0;i<V;i++){
if(indegre[i]==0){
vis[i]=1;
q.add(i);
}
}
int count=0;
while(!q.isEmpty()) {
int node=q.poll();
count++;
for(int it:adj.get(node)){
if(vis[it]==0){
indegre[it]--;
if(indegre[it]==0){
q.add(it);
vis[it]=1;
}
}
}
}
return count>=V;
    }
}