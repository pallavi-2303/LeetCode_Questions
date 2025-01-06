class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> mp=new HashMap<>();
    int n=nums.length;
     for(int num:nums){
mp.put(num,mp.getOrDefault(num,0)+1);
     }  
     int key=-1;
     for(int it:mp.keySet()) {
        if(mp.get(it)>n/2){
            key=it;
        }
     }
     return key;
    }
}