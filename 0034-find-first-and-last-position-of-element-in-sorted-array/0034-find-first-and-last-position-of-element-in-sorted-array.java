class Solution {
    public int findFloor(int[] nums,int target){
    int n=nums.length;
    int floor=-1;
    int low=0;
    int high=n-1;
    while(low<=high){
        int mid=low+(high-low)/2;
        if(nums[mid]==target){
            floor=mid;
            high=mid-1;
        }
        else if(nums[mid]<target){
            low=mid+1;
        }
        else {
            high=mid-1;
        }
    }
    return floor;
    }
    public int findCeil(int[] nums,int target){
    int n=nums.length;
    int ceil=-1;
    int low=0;
    int high=n-1;
    while(low<=high){
    int mid=low+(high-low)/2;
    if(nums[mid]==target){
        ceil=mid;
        low=mid+1;
    }
    else if(nums[mid]<target){
    low=mid+1;
    }
    else {
        high=mid-1;
    }
    }
    return ceil;
    }
    public int[] searchRange(int[] nums, int target) {
    int n=nums.length;
    int floor=findFloor(nums,target);
    int ceil=findCeil(nums,target);
    int[] ans=new int[]{floor,ceil};
    return ans;
    }
}