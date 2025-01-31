class Solution {
public int Tabu(List<Integer> arr,int n,int[] dp){
   // dp[0]=arr.get(0);
    int prev2=0;
    int prev=arr.get(0);
    for(int i=1;i<n;i++){
       /* int take=arr.get(i);
        if(i>1) take+=dp[i-2];
        int nottake=0+dp[i-1];
        dp[i]=Math.max(take,nottake);*/
        int take=arr.get(i)+prev2;
        int nottake=prev;
        int curr=Math.max(take,nottake);
        prev2=prev;
        prev=curr;
    }
   // return dp[n-1];
    return prev;
}
    public int Memo(List<Integer> arr,int idx,int[] dp){
        if(idx<0) return 0;
        if(idx==0) return arr.get(0);
        if(dp[idx]!=-1) return dp[idx];
        int take=arr.get(idx)+Memo(arr,idx-2,dp);
        int nottake=0+Memo(arr,idx-1,dp);
        return dp[idx]=Math.max(take,nottake);
    }
    public int rob(int[] nums) {
    int n=nums.length;
    List<Integer> temp1=new ArrayList<>();
    List<Integer> temp2=new ArrayList<>();
        if(n==1) return nums[0];
        for(int i=0;i<n;i++){
            if(i!=n-1) temp1.add(nums[i]);
            if(i!=0) temp2.add(nums[i]);
        }
    int size=n-1;
//we have to find cost so we can find cost in which one element have and some in last element have and find max of the both
   /* int[] dp=new int [size];
        Arrays.fill(dp,-1);
    int ans1=Memo(temp1,size-1,dp);
    Arrays.fill(dp,-1);
    int ans2=Memo(temp2,size-1,dp);
        return Math.max(ans1,ans2);*/
        int[] dp=new int[size];
        int ans1=Tabu(temp1,size,dp);
        Arrays.fill(dp,0);
        int ans2=Tabu(temp2,size,dp);
        return Math.max(ans1,ans2);
    }
}