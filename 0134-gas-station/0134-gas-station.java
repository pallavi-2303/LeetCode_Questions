class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
         int n=gas.length;
         int totalCost=0;
         int totalGas=0;
         for(int i=0;i<n;i++){
        totalCost+=cost[i];
        totalGas+=gas[i];
         }

//not possible case
if(totalGas<totalCost) return -1;
int total=0;
int ans=0;
for(int i=0;i<n;i++){
total+=gas[i]-cost[i];
if(total<0){
total=0;
ans=i+1;//next index woulbe answer and it is guranned that one naswer exist and the nymber that come first whose total is grater than 0 will go to end
}
}
return ans;

    }
}