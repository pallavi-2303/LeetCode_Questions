class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
      int mod=(int)1e9+7;
//brute force
List<Long> ans=new ArrayList<>();
for(int i=0;i<n;i++){
long sum=0;
for(int j=i;j<n;j++){
sum=(sum+(long)nums[j])%mod;
ans.add(sum);
}
}
Collections.sort(ans);
long res=0;
for(int i=left;i<=right;i++){
res=(res+ans.get(i-1))%mod;
}
return (int)res;  
    }
}