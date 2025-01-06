class Solution {
    public int[] twoSum(int[] nums, int target) {
      int n=nums.length;
      //brute force ->generating all the subarray and finding out the sum
     /* int[] ans={-1};
      for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
       if(nums[i]+nums[j]==target) {
        ans=new int[]{i,j};
       }    
        }
      }*/
      //optimal aproach->using a hashmap to store previous element
     HashMap<Integer,Integer> mp=new HashMap<>();
     int[] ans={-1};
    for(int i=0;i<n;i++) {
    int rem=target-nums[i];
    if(mp.containsKey(rem)){
    //means arr[i]+rem==target
    ans=new int[]{mp.get(rem),i};
    }
    mp.put(nums[i],i);
    }
return ans;
    }
}