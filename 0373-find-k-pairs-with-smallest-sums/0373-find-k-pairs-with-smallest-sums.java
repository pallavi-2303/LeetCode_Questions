class Solution {
    public class tuple{
int sum;
int idxi;
int idxj;
public tuple(int sum,int idxi,int idxj) {
this.sum=sum;
this.idxi=idxi;
this.idxj=idxj;
}
}
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
      //brute force trying out all the possible pairs till k and when sum is greater than k we will remove that
PriorityQueue<tuple> pq=new PriorityQueue<>((a,b)->Integer.compare(b.sum,a.sum));
int n=nums1.length;
int m=nums2.length;
for(int i=0;i<n;i++){
for(int j=0;j<m;j++){
int sum=nums1[i]+nums2[j];
if(pq.size()<k) {
pq.add(new tuple(sum,i,j));
}
else if(sum<pq.peek().sum) {
pq.poll();
pq.add(new tuple(sum,i,j));
}
else {
//if pq size is greater and equal to k now next j value will be greater than this sum so just break the loop
break;
}
}
}
List<List<Integer>> res=new ArrayList<>();
while(!pq.isEmpty()) {
tuple it=pq.poll();
List<Integer> temp=new ArrayList<>();
temp.add(nums1[it.idxi]);
temp.add(nums2[it.idxj]);
res.add(temp);
}
Collections.reverse(res);
return res; 
    }
}