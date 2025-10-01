class Solution {
int n;
public int lowerBound(int l,int[][] arr,int target){
int r=n;
while(l<r){
int mid=l+(r-l)/2;
if(arr[mid][0]>=target){
r=mid;
}
else {
l=mid+1;
}
}
return l;
}
public int solve(int idx,int[][] arr,int[] dp){
if(idx>=n) return 0;
if(dp[idx]!=-1) return dp[idx];
//at any index we have two options yake and not take
int nextIdx=lowerBound(idx,arr,arr[idx][1]);
int take=arr[idx][2]+solve(nextIdx,arr,dp);
int notTake=solve(idx+1,arr,dp);
return dp[idx]=Math.max(take,notTake);
}
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
//Now we have to add all this in one and sort according to starting time
    n=startTime.length;
int[][] arr=new int[n][3];
for(int i=0;i<n;i++){
arr[i][0]=startTime[i];
arr[i][1]=endTime[i];
arr[i][2]=profit[i];
}
Arrays.sort(arr,Comparator.comparingInt(vec->vec[0]));
int[] dp=new int[n+1];
/*Arrays.fill(dp,-1);
    return solve(0,arr,dp);*/
for(int i=n-1;i>=0;i--){
int nextIdx=lowerBound(i,arr,arr[i][1]);
int take=arr[i][2];
if(nextIdx!=i) {
take+=dp[nextIdx];
}
int notTake=dp[i+1];
dp[i]=Math.max(take,notTake);
}
    return dp[0];
    }
}