class Solution {
    public int[] twoSum(int[] nums, int target) {
      int[] ans={-1};
int n=nums.length;
/*Brute force
for(int i=0;i<n;i++){
for(int j=i+1;j<n;j++){
if(nums[i]+nums[j]==target){
ans=new int[]{i,j};
break;}}}
return ans; */
HashMap<Integer,Integer> mp=new HashMap<>();
for(int i=0;i<n;i++){
int remain=target-nums[i];
if(mp.containsKey(remain)){
ans=new int[]{mp.get(remain),i};
break;}
mp.put(nums[i],i);}
return ans;

    }
}