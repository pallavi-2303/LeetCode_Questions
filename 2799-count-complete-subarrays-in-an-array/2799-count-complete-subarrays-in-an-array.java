class Solution {
    public int findSubarray(int[] nums,int goal){
    if(goal<0) return 0;
    HashMap<Integer,Integer> mp=new HashMap<>();
    int count=0;
    int n=nums.length;
    int i=0;
    int j=0;
    while(j<n){
    mp.put(nums[j],mp.getOrDefault(nums[j],0)+1);
    while(mp.size()>goal){
    mp.put(nums[i],mp.get(nums[i])-1);
    if(mp.get(nums[i])==0){
    mp.remove(nums[i]);
    }
    i++;
    }
    count+=(j-i+1);
    j++;
    }
    return count;
    }
    public int countCompleteSubarrays(int[] nums) {
    int n=nums.length;
    //number of subarray with numbers equal to nums lesss than equal to distcnt-less than equal to distnct-1
    HashMap<Integer,Integer> mp=new HashMap<>();
    for(int num:nums) mp.put(num,mp.getOrDefault(num,0)+1);
    return findSubarray(nums,mp.size())-findSubarray(nums,mp.size()-1);
    }
}