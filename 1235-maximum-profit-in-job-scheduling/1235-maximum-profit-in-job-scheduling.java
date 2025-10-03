class Solution {
int n;
int[] dp;
public int upperBound(int  target,int[][] arr,int l){
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
public int solve(int idx,int[][] arr){
if(idx>=n) return 0;
if(dp[idx]!=-1){
return dp[idx];
}
int notTake=solve(idx+1,arr);
int take=arr[idx][2];
int nextIdx=upperBound(arr[idx][1],arr,idx);
take+=solve(nextIdx,arr);
return dp[idx]=Math.max(take,notTake);
}
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
   //since job can be done in any order we just have to maximise the profit and at any index if have two options either to do the current job or leave it.
n=profit.length;
int[][] arr=new int[n][3];
for(int i=0;i<n;i++){
arr[i][0]=startTime[i];
arr[i][1]=endTime[i];
arr[i][2]=profit[i];
}
//Sort on badais of start time so that starttone can be independent 
Arrays.sort(arr, Comparator.comparingInt(a->a[0]));
dp=new int[n+1];
Arrays.fill(dp,-1);
return solve(0,arr);     
    }
}