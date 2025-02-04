class Solution {
    public int maxAscendingSum(int[] nums) {
     int n=nums.length;
     int maxi=1;
      for(int i=0;i<n;i++){
        int sum=nums[i];
    for(int prev=i+1;prev<n;prev++) {
    if(nums[prev-1]<nums[prev]){
    sum+=nums[prev];
    }
    else {
    break;
    }
    }
    maxi=Math.max(maxi,sum);}
    return maxi;
    }
}