class Solution {
    public int singleNumber(int[] nums) {
    // HashMap<Integer,Integer> mp=new HashMap<>();
    // for(int num:nums) mp.put(num,mp.getOrDefault(num,0)+1);
    // int ans=-1;
    // for(int it:mp.keySet()) {
    // if(mp.get(it)==1) return it;
    // }
    // return ans;
//since all thrice numbers appear in pair 
Arrays.sort(nums);
int i=1;
while(i<nums.length){
if(nums[i]!=nums[i-1]){
//single element comes in betwwn
return nums[i-1];
}
i+=3;
}
return nums[nums.length-1];
    }
}