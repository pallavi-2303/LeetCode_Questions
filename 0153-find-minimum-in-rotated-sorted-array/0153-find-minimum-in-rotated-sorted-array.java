class Solution {
    public int findMin(int[] nums) {
     int n=nums.length;
     int low=0;
     int high=n-1;
     int ans=Integer.MAX_VALUE;
     while(low<=high) {
    int mid=low+(high-low)/2;
    //if the entire array is sorted
    if(nums[low]<=nums[high]){
        ans=Math.min(ans,nums[low]);
        break;
    }
    //finding out which part is sorted sorted part may or maynt have the answer 
    if(nums[low]<=nums[mid]){
    //left part is sorted so store the min
ans=Math.min(nums[low],ans);
//move to check in right
low=mid+1;
    }
    else {
    //the right part is sorted
    ans=Math.min(nums[mid],ans);
    high=mid-1;
    }
     }  
     return ans;
    }
}