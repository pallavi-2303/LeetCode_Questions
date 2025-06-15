class Solution {
    int mod=1000000007;
    public class pair {
        int speed;
        int efficiency;

    public pair( int speed,int efficiency) {
    this.speed=speed;
    this.efficiency=efficiency;
    }   
    }

        public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
            //since we have to find max amog k by amximiing we have to take it comparitively by first taking the max efiiceiency
            List<pair> arr = new ArrayList<>();

for(int i=0;i<n;i++){
  arr.add(new pair(speed[i],efficiency[i]));  
}
Collections.sort(arr,(a,b)->Integer.compare(b.efficiency,a.efficiency));
PriorityQueue<Integer> pq=new PriorityQueue<Integer>((a,b)->Integer.compare(a,b));
long sum=0;
long result=0;
for(pair it:arr){
int speed2=it.speed;
int efficiency2=it.efficiency;
sum=sum+(long)speed2;
pq.offer(speed2);//push the speed;
if(pq.size()>k){
sum-=(long)pq.poll();
}
result=Math.max(result,(sum*efficiency2));
}
return (int)(result%mod);
        }
}