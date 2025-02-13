class Solution {
    public int minOperations(int[] nums, int k) {
       int n=nums.length;
int op=0;
PriorityQueue<Long> pq=new PriorityQueue<>();
for(int num:nums) {
 pq.offer((long)num);
}
while(pq.size()>=2) {
long x=pq.poll();
if(x>=k) break;
long y=pq.poll();
long res=Math.min(x,y)*2+Math.max(x,y);
pq.offer(res);
op++;
}
return op; 
    }
}