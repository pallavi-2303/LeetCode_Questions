class KthLargest {
class pair{
int num;
int k;
pair(int num,int k){
this.num=num;
this.k=k;
}
}
PriorityQueue<pair> pq;
    public KthLargest(int k, int[] nums) {
     pq=new PriorityQueue<pair>((x,y)->x.num-y.num);
     for(int num:nums){
    pq.add(new pair(num,k));
     }   
    }
    
    public int add(int val) {
if(pq.isEmpty()) return -1;
  int K=pq.peek().k;
     pq.add(new pair(val,K));
     while(!pq.isEmpty() && pq.size()>K) pq.poll();
     return pq.peek().num; 
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */