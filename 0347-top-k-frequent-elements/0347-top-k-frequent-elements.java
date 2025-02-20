class Solution {
    public int[] topKFrequent(int[] nums, int k) {
      int n=nums.length;
int[] ans=new int[k];
HashMap<Integer,Integer> mp=new HashMap<>();
for(int num:nums) {
mp.put(num,mp.getOrDefault(num,0)+1);   
}
PriorityQueue<Integer> pq=new PriorityQueue<>((x,y)->mp.get(y)-mp.get(x));
for(int it:mp.keySet()) pq.offer(it);
int idx=0;
while(!pq.isEmpty() && k>0) {
 ans[idx++]=pq.poll();
 k--;
}
return ans;  
    }
}