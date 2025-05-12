class Solution {
 int N;
public int solve(int i,int currentRate,int[] time,int[] position,int[][][] dp,int k){
if(i==N-1){
if(k>0){
return Integer.MAX_VALUE;
}
else return 0;
}
if(dp[i][k][currentRate]!=-1){
return dp[i][k][currentRate];
}
//at particular index we decide to take or not take
int result=Integer.MAX_VALUE;
int notMergeResult=solve(i+1,time[i+1],time, position,dp,k);
if(notMergeResult!=Integer.MAX_VALUE) {
int currDis=position[i+1]-position[i];
result=Math.min(result,notMergeResult+currDis*currentRate);}
//if we decide to merge at a particular index .
if(k>0){
int mergeCount=0;
int mergeTime=time[i+1];
//try to merge the index i+1 and i+2 
for(int j=i+2;j<N && mergeCount<k;j++){
mergeCount++;
 mergeTime+=time[j];
int mergeResult=solve(j,mergeTime,time,position,dp,k-mergeCount);
if(mergeResult!=Integer.MAX_VALUE){
int currDis=position[j]-position[i];
result=Math.min(result,mergeResult+currDis*currentRate);
}
}}
return dp[i][k][currentRate]=result;
}
    public int minTravelTime(int l, int n, int k, int[] position, int[] time) {
        this.N=n;
int totalSum=0;
for(int t:time) {
totalSum+=t;
}
int[][][] dp=new int[n+1][k+1][totalSum+1];
for(int[][] arr2:dp) {
for(int[] arr1:arr2){
Arrays.fill(arr1,-1);
}
}
return solve(0,time[0],time, position,dp,k); 
    }
}