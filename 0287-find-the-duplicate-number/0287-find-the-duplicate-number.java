class Solution {
    public int findDuplicate(int[] nums) {
    int n=nums.length;
    HashSet<Integer> st=new HashSet();
    for(int num:nums)  {
    if(st.contains(num)){
    return num;
    }
else {
st.add(num);
}
    } 
    return -1; 
    }
}