class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
      //since we have to maintain csndidataes we try to run the loop from start and put in pq 1 and last to pq 2 and give smallest among them
      int n=costs.length;
      long res=0;
      PriorityQueue<Integer> pq1=new PriorityQueue<>((a,b)->Integer.compare(a,b));
       PriorityQueue<Integer> pq2=new PriorityQueue<>((a,b)->Integer.compare(a,b));
      int i=0;
      int j=n-1;
      while(k>0){
//put candidates from array in pq1 and pq2 from end
while(i<=j && pq1.size()<candidates ){
pq1.offer(costs[i]);
i++;
}
while(j>=i && pq2.size()<candidates ){
pq2.offer(costs[j]);
j--;
}
int ele1=pq1.isEmpty()? Integer.MAX_VALUE:pq1.peek();
int ele2=pq2.isEmpty()? Integer.MAX_VALUE:pq2.peek();
if(ele1<=ele2){
res+=ele1;
pq1.poll();
}
else {
res+=ele2;
pq2.poll();
}
k--;}  
return res;
    }
}