class Solution {
    public int searchInsert(int[] nums, int target) {
      //we have to found the first position where element owould be present if it is not present first index it will be there
    int n=nums.length;
    int ans=n;
    int low=0;
    int high=n-1;
    while(low<=high) {
    int mid=low+(high-low);
    if(nums[mid]==target){
        return mid;
    }
    else if(nums[mid]<target){
        low=mid+1;
    }
    else {
ans=mid;
high=mid-1;
    }}
    return ans;
    }
}