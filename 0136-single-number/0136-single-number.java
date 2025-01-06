class Solution {
    public int singleNumber(int[] nums) {
    int n=nums.length;
    //brute force of storing frequency,number
    if(n==1) return nums[0];
     HashMap<Integer,Integer> mp=new HashMap<>(); 
     for(int num:nums){
        mp.put(num,mp.getOrDefault(num,0)+1);
     }
     for(int it:mp.keySet()){
        if(mp.get(it)==1){
            return it;
        }
     }
     return -1;//returing a default value
    }
}