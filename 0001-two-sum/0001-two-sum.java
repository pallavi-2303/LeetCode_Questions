class Solution {
    public int[] twoSum(int[] nums, int target) {
     int n=nums.length;
     int[] ans={-1};
     //brute force->Generating all subarray
    //  for(int i=0;i<n;i++) {
    // for(int j=i+1;j<n;j++){
    // if(nums[i]+nums[j]==target){
    // ans=new int[]{i,j};
    // }
    // }
    //  }  
    //  return ans;
    HashMap<Integer,Integer> mp=new HashMap<>();
    for(int i=0;i<n;i++){
    int remele=target-nums[i];
    if(mp.containsKey(remele)){
    ans=new int[]{mp.get(remele),i};
    }
    mp.put(nums[i],i);
    }
    return ans;
    }
}