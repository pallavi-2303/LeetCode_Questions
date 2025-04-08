class Solution {
    public int minimumOperations(int[] nums) {
    //number of operations will be equal to total ellemnts /3 till duplicate
    HashSet<Integer> st=new HashSet<>();
    for(int i=nums.length-1;i>=0;i--){
    if(st.contains(nums[i])){
    return (int)Math.ceil((i+1)/3.0);
    }
    st.add(nums[i]);
    }  
    return 0; 
    }
}