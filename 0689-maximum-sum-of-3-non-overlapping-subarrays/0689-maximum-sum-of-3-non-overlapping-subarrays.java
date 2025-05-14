class Solution {
    private int[][] dp=new int[20001][4];
    public int helper(int idx,int count,int[] subarray,int n,int k){
//Base case
if(count==0) return 0;
if(idx>=n) return Integer.MIN_VALUE;//array not finished invalid case
if(dp[idx][count]!=-1) return dp[idx][count];
int take=subarray[idx]+helper(idx+k,count-1,subarray,n,k);
int nottake=helper(idx+1,count, subarray,n,k);
return dp[idx][count]= Math.max(take,nottake);}
    public void solve(int idx,int count,int[] subarray,int n,List<Integer> res,int k){
//This is for selecting the index that has to be included 
if(count==0) return;
if(idx>=n) return;
int takeIndex=subarray[idx]+helper(idx+k,count-1,subarray,n,k);
int nottake=helper(idx+1,count,subarray,n,k);
//Check whether taking given index is profitable for not 
if(takeIndex>=nottake){
res.add(idx);
solve(idx+k,count-1,subarray,n,res,k);}
else {
solve(idx+1,count,subarray,n,res,k);}}
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
    //since we have to find the sum of two k subarray we can precompute it
int n=nums.length-k+1;
int[] subSum=new int[n];
int l=0;
int r=0;
int m=nums.length;
int idx=0;
int sum=0;
while(r<m){
sum+=nums[r];
if((r-l)+1==k){
subSum[idx++]=sum;
sum-=nums[l];
l++;}
r++;}
for(int[] a:dp)
Arrays.fill(a,-1);
List<Integer> ans=new ArrayList<>();
 solve(0,3,subSum,n,ans,k);
return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}