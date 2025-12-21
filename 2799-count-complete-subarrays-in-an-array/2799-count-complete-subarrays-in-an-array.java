class Solution {
    public int countCompleteSubarrays(int[] nums) {
     int n=nums.length;
     HashMap<Integer,Integer> mp=new HashMap<>();
     for(int num:nums) {
    mp.put(num,mp.getOrDefault(num,0)+1);
     } 
    int size=mp.size();
    int count=0;
    for(int i=0;i<n;i++) {
    HashMap<Integer,Integer> temp=new HashMap<>();
    for(int j=i;j<n;j++){
    temp.put(nums[j],temp.getOrDefault(nums[j],0)+1);
    if(temp.size()==size){
    count++;
    }
    }
    }
    return count++;
    }
}