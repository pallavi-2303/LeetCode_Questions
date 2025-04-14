class Solution {
    public int findKthLargest(int[] nums, int k) {
      PriorityQueue<Integer> pq=new PriorityQueue<>((x,y)->Integer.compare(x,y)) ;
      for(int num:nums) {
    pq.add(num);
    if(pq.size()>k) pq.poll();
      }

      return pq.peek();
    }
}