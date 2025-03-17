class Solution {
    public boolean divideArray(int[] nums) {
     Set<Integer> st=new HashSet<>();
     for(int num:nums){
    if(st.contains(num)){
    st.remove(num);
    }
    else {
    st.add(num);
    }
     }  
     return st.isEmpty(); 
    }
}