class Solution {
    public int[] twoSum(int[] nums, int target) {
    int[] ans={-1} ;
    //brute force;
    int n=nums.length;
for(int i=0;i<n;i++){
for(int j=i+1;j<n;j++){
if(nums[i]+nums[j]==target){
ans=new int[]{i+1,j+1};
break;
}
}
}
return ans;
    }
}