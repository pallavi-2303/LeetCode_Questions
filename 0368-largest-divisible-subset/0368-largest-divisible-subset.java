class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
     int n=nums.length;
     List<Integer> ans=new ArrayList<>();
     int[] dp=new int[n];
     int[] hash=new int[n];
     Arrays.fill(dp,1);
     for(int i=1;i<n;i++) {
    //initially marking for the current index
    hash[i]=i;
    for(int prev=0;prev<i;prev++){
    if(nums[i]%nums[prev]==0 && 1+dp[prev]>dp[i]){
    dp[i]=1+dp[prev];
    //mark the index of pprevious sequence;
    hash[i]=prev;
    }
    }
     }
    //finding out the last ellemnt and last index whose dp valus if maximum
    int maxLen=0;
    int lastIdx=-1;
    for(int i=0;i<n;i++){
    if(dp[i]>maxLen){
    maxLen=dp[i];
    lastIdx=i;
    }
    }
  ans.add(nums[lastIdx]);
  while(hash[lastIdx]!=lastIdx){
lastIdx=hash[lastIdx];
ans.add(nums[lastIdx]);
  }
  return ans;
    }
}