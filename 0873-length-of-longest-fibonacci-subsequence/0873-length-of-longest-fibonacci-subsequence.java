class Solution {
    public int solve(int[] nums,int j,int k,HashMap<Integer,Integer> mp,int[][] dp){
if(dp[j][k]!=-1) return dp[j][k];
int numi=nums[k]-nums[j];
if(mp.containsKey(numi) && mp.get(numi)<j){
int i=mp.get(numi);
return dp[j][k]=solve(nums,i,j,mp,dp)+1;//for k 
}
return dp[j][k]=2;//for i and j 
    }
    public int lenLongestFibSubseq(int[] nums) {
  int n=nums.length;
int maxlen=0;
HashMap<Integer,Integer> mp=new HashMap<>();
int[][] dp=new int[n][n];
for(int[] a:dp){
Arrays.fill(a,-1);}
for(int i=0;i<n;i++){
mp.put(nums[i],i);}
for(int j=1;j<n;j++){
for(int k=j+1;k<n;k++){
//we will try to find a for given b and c
int len=solve(nums,j,k,mp,dp);
if(len>=3){
maxlen=Math.max(len,maxlen);}}}
return maxlen;
    }
}