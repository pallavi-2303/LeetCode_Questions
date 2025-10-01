class Solution {
int n;
int[][] dp;
public int upperBound(int low,int[][] arr,int target){
int high=n;
while(low<high){
int mid=low+(high-low)/2;
if(arr[mid][0]<=target){
low=mid+1;
}
else high=mid;
}
return low; 
}
public int solve(int idx,int[][] events,int k,int[][] dp){
if(idx>=n || k==0) return 0;
if(dp[idx][k]!=-1) return dp[idx][k];
//at any index we hae two options wheather to take the current index or not
int notTake=solve(idx+1,events,k,dp);
int take=events[idx][2];
int nextIdx=upperBound(idx+1,events,events[idx][1]);
take+=solve(nextIdx,events,k-1,dp);
return dp[idx][k]= Math.max(notTake,take);
}
    public int maxValue(int[][] events, int k) {
       n=events.length;
       dp=new int[n+1][k+1];
       for(int[] a:dp) Arrays.fill(a,-1);
       Arrays.sort(events,Comparator.comparingInt(event->event[0])) ;
       return solve(0,events,k,dp);
    }
}