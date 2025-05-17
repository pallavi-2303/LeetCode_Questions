class Solution {
      public class pair{
int capital;
int profit;
public pair(int capital,int profit){
this.capital=capital;
this.profit=profit;
}
}
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
//who is stoping you to earn profit is capital as onmy those projects can be done whose capital is less than w
List<pair> arr=new ArrayList<>();
int n=capital.length;
for(int i=0;i<n;i++){
arr.add(new pair(capital[i],profits[i]));
}
//sort the list on basis of capital
//Tc->O(nlogn) for sorting 
Collections.sort(arr,(a,b)->Integer.compare(a.capital,b.capital));
//PriorityQueue firbstoring amx profit for that capital;
PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->Integer.compare(b,a));
int i=0;
//klogn worst case nlogn if all task can be done;
while(k>0){
while(i<n && arr.get(i).capital<=w){
pq.add(arr.get(i).profit);
i++;
}
if(pq.isEmpty()) break;
w+=pq.peek();
pq.poll();
k--;
}
return w;
    }
}