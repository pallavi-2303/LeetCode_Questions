class Solution {
    public long maxKelements(int[] nums, int k) {
        int n=nums.length;
PriorityQueue<Long> pq=new PriorityQueue<>((a,b)->Long.compare(b,a));
for(int i=0;i<n;i++){
pq.add((long)nums[i]);
}
long score=0;
while(!pq.isEmpty() && k>0){
long Element =pq.poll();
score+=Element;
long newNumber=(long)Math.ceil((Element/3.0));
pq.add(newNumber);
k--;
}
return score;
    }
}