class Solution {
    public int[] topKFrequent(int[] nums, int k) {
   int n=nums.length;
   HashMap<Integer,Integer> mp=new HashMap<>();
   for(int num:nums) mp.put(num,mp.getOrDefault(num,0)+1);
   PriorityQueue<Integer> pq=new PriorityQueue((x,y)->Integer.compare(mp.get(y),mp.get(x)));
for(int key:mp.keySet()){
pq.add(key);
}   
int[] res=new int[k] ;
int idx=0;
while(!pq.isEmpty() && idx<k){
res[idx++]=pq.poll();
}
return res;
    }
}