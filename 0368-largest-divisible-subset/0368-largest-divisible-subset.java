class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
       int n=nums.length;
//here we can store the length and longest increasing subset
Arrays.sort(nums);
int[] dp=new int[n];
Arrays.fill(dp,1);
int[] hash=new int[n];
for(int i=1;i<n;i++){
 hash[i]=i;
for(int prev=0;prev<i;prev++){
if(nums[i]%nums[prev]==0 && 1+dp[prev]>dp[i]) {
dp[i]=1+dp[prev];
hash[i]=prev;}}}
int lastidx=-1;
int lastele=0;
for(int i=0;i<n;i++){
if(dp[i]>lastele) {
 lastele=dp[i];
 lastidx=i;}}
List<Integer> ans=new ArrayList<>();
ans.add(nums[lastidx]);
while(lastidx!=hash[lastidx]) {
 lastidx=hash[lastidx];
 ans.add(nums[lastidx]);
}
return ans; 
    }
}