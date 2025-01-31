class Solution {
    public int memo(int idx,List<Integer> arr,int[] dp){
    if(idx==0) return arr.get(0);
    if(dp[idx]!=-1) return dp[idx];
    int take=arr.get(idx);
    if(idx-2>=0) take+=memo(idx-2,arr,dp);
    int nottake=memo(idx-1,arr,dp);
    return dp[idx]=Math.max(take,nottake);
    }
    public int tabu(List<Integer> arr){
    int n=arr.size();
    //int[] dp=new int[n];
   // dp[0]=arr.get(0);
   int prev=arr.get(0);
   int prev2=0;
    for(int idx=1;idx<n;idx++){
    int take=arr.get(idx);
    if(idx>1) 
    //take+=dp[idx-2];
    take+=prev2;
   // int nottake=dp[idx-1];
   nottake=prev;
   // dp[idx]=Math.max(take,nottake);
   int curr=Math.max(take,nottake);
   prev2=prev;
   prev=curr;
    }
  //  return dp[n-1];
  return prev;
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
    // int[] dp=new int[n-1];
    // Arrays.fill(dp,-1);
    // int ans1=memo(n-2,temp1,dp);
    // Arrays.fill(dp,-1);
    // int ans2=memo(n-2,temp2,dp);
    // return Math.max(ans1,ans2);
    //tabulation
    int ans=tabu(temp1);
    int ans2=tabu(temp2);
    return Math.max(ans,ans2);
    }
}