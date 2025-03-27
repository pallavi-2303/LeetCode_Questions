class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
     //if gas-cost>0 then only we can travel
     int n=gas.length;
     int diff=0;
     int res=0;
     int ans=0;
     for(int i=0;i<n;i++){
    diff+=(gas[i]-cost[i]);
    res+=(gas[i]-cost[i]);
    if(res<0){
    res=0;
    ans=i+1;
    }
     }
if(diff<0 || ans>=n) return -1;
return ans;
    }
}