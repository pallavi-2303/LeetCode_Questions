class Solution {
    public class pair{
    int cap;
    int pro;
    pair(int cap,int pro){
    this.cap=cap;
    this.pro=pro;
    }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
    //we can perform the activity on basis of capital only 
    List<pair> arr=new ArrayList<>();
    int n=capital.length;
    for(int i=0;i<n;i++){
    arr.add(new pair(capital[i],profits[i]));
    }
    Collections.sort(arr,(a,b)->Integer.compare(a.cap,b.cap));
//we want priotity for storing max profit if we have  maximum  for same capital
PriorityQueue<Integer> pq=new  PriorityQueue<>((a,b)->Integer.compare(b,a));
int i=0;
while(k>0){
while(i<n && arr.get(i).cap<=w){
pq.offer(arr.get(i).pro);
i++;
}
if(pq.isEmpty()) break;
w+=pq.poll();
k--;
}
return w;

    }
}