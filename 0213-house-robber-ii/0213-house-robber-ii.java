class Solution {
    public int memo(int idx,List<Integer> arr,int[] dp){
    if(idx==0) return arr.get(0);
    if(dp[idx]!=-1) return dp[idx];
    int take=arr.get(idx);
    if(idx-2>=0) take+=memo(idx-2,arr,dp);
    int nottake=memo(idx-1,arr,dp);
    return dp[idx]=Math.max(take,nottake);
    }
    public int rob(int[] nums) {
    //since we cannot take both the houses at the same time we can take two arrays ind in one we can take 0th element and in second we can take n-1 element 
    int n=nums.length;
    List<Integer> temp1=new ArrayList<>();
    List<Integer> temp2=new ArrayList<>();
    if(n==1) return nums[0];
    for(int i=0;i<n;i++){
    if(i!=n-1) temp1.add(nums[i]);
    if(i!=0) temp2.add(nums[i]);
    }
    int[] dp=new int[n-1];
    Arrays.fill(dp,-1);
    int ans1=memo(n-2,temp1,dp);
    Arrays.fill(dp,-1);
    int ans2=memo(n-2,temp2,dp);
    return Math.max(ans1,ans2);
    }
}