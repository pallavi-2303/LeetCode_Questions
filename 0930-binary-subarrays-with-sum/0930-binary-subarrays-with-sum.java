class Solution {
    public int sumOfGoal(int[] nums,int goal){
        int n=nums.length;
        int count=0;
        int sum=0;
        if(goal<0) return 0;
        int l=0;
        int r=0;
        while(r<n){
        sum+=nums[r];
        while(sum>goal){
            sum-=nums[l];
            l++;
        }
        //sum<=goal
        count+=(r-l+1);
        r++;
        }
        return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
    /* int n=nums.length;
     int count=0;
    //brute force generating all the subarray
    for(int i=0;i<n;i++){
        int sum=0;
    for(int j=i;j<n;j++){
    sum+=nums[j];
    if(sum==goal) count++;
    else if(sum>goal) break;
    }
    }  
    return count;  */
    //optimal aparoach of using a sliding window maximum sum<=goal-sum<=goal-1
    return sumOfGoal(nums,goal)-sumOfGoal(nums,goal-1);
    }
}