class Solution {
    public long findScore(int[] nums) {
      int n=nums.length;
int[] vis=new int[n];
PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]!=b[0] ? Integer.compare(a[0],b[0]) : Integer.compare(a[1],b[1]));
//since we need smallest element all the time we can think of PriorityQueue 
for(int i=0;i<n;i++){
pq.add(new int[]{nums[i],i});
}
long score=0;
while(!pq.isEmpty()){
int[] a=pq.poll();
int ele=a[0];
int index=a[1];
//when to add if it is unvisited
if(vis[index]==0){
vis[index]=1;
score=score+(long)ele;
int prevIdx=index-1;
int nextIdx=index+1;
if(prevIdx>=0) vis[prevIdx]=1;
if(nextIdx<n) vis[nextIdx]=1;
}
}
return score;  
    }
}