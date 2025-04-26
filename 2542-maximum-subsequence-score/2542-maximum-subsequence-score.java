class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        //since we will sort the nums2 in decending order and we will also keep the corresponding element of num1 to it
int n=nums1.length;
int[][] temp=new int[n][2];
for(int i=0;i<n;i++){
temp[i][0]=nums1[i];
temp[i][1]=nums2[i];
}
//sort according to num2 decending order
Arrays.sort(temp,(a,b)->Integer.compare(b[1],a[1]));
//first we will find out the sum of k elements
PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->Integer.compare(a,b));
int sumk=0;
long res=0;

for(int i=0;i<k;i++){
sumk+=temp[i][0];
pq.offer(temp[i][0]);
}
res=sumk*temp[k-1][1];
for(int i=k;i<n;i++){
sumk-=pq.poll();
sumk+=temp[i][0];
pq.offer(temp[i][0]);
res=Math.max(res,(long)sumk*(long)temp[i][1]);
}
return res;
    }
}