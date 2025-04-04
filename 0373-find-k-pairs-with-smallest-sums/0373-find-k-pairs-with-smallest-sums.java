class Solution {
    public class tuple{
    int sum;
    int idxi;
    int idxj;
    public tuple(int sum,int idxi,int idxj){
    this.sum=sum;
    this.idxi=idxi;
    this.idxj=idxj;
    }
    }
    public class pair{
    int idx_i;
    int idx_j;
    pair(int idx_i,int idx_j){
    this.idx_i=idx_i;
     this.idx_j=idx_j; }
     @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof pair)) return false;
        pair other = (pair) o;
        return this.idx_i == other.idx_i && this.idx_j == other.idx_j;
    }

    @Override
    public int hashCode() {
        return 31 * idx_i + idx_j;
    }
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    int n=nums1.length;
    int m=nums2.length;
    HashSet<pair> vis=new HashSet<>();
PriorityQueue<tuple> pq=new  PriorityQueue<>((a,b)->(Integer.compare(a.sum,b.sum)));
//at start
pq.add(new tuple(nums1[0]+nums2[0],0,0));
vis.add(new pair(0,0));
List<List<Integer>> res=new  ArrayList<>();
while(k>0 && !pq.isEmpty()){
//if it has come out it has minimum sum
tuple it=pq.poll();
int i=it.idxi;
int j=it.idxj;
List<Integer> temp=Arrays.asList(nums1[i],nums2[j]);
res.add(temp);
//adding the valid pair  in pq
if(j+1<m && !vis.contains(new pair(i,j+1))){
pq.add(new tuple(nums1[i]+nums2[j+1],i,j+1));
vis.add(new pair(i,j+1));
}
if(i+1<n && !vis.contains(new pair(i+1,j))){
pq.add(new tuple(nums1[i+1]+nums2[j],i+1,j));
vis.add(new pair(i+1,j));
}
k--;
}
return res;
        
    }
}