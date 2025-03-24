class Solution {
    public int findDuplicate(int[] nums) {
     int n=nums.length;
     HashSet<Integer> st=new HashSet<>();
     for(int i=0;i<n;i++) {
    if(st.contains(nums[i])){
    return nums[i];
    }
    st.add(nums[i]);
     }  
     return -1;
    }
}