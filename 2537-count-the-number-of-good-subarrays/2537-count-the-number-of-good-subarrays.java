class Solution {
    public long countGood(int[] nums, int k) {
    //since we have to find k pairs and we  have given subarray we can use sliding window maximum if we get a subarray with k pairs extending the subarray from right will always be valid
int n=nums.length;
long count=0;
long pairs=0;
HashMap<Integer,Integer> mp=new HashMap<>();
int l=0;
int r=0;
while(r<n){
//if the key is already present it contributeto pair
if(mp.containsKey(nums[r])){
pairs+=mp.get(nums[r]);
}
mp.put(nums[r],mp.getOrDefault(nums[r],0)+1);
//if we fount a valid window
while(pairs>=k){
count+=(n-r);//this the good subrary count  from j too end
mp.put(nums[l],mp.get(nums[l])-1);
pairs-=mp.get(nums[l]);
l++;
}
r++;
}
return count;

    }
}