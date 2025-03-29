class Solution {
    public int longestConsecutive(int[] nums) {
    HashSet<Integer> st=new HashSet<>();
    for(int  it:nums) st.add(it);
    int maxLen=0;
    for(int it:st)  {
    //if it tthe first occurence
    if(!st.contains(it-1)){
    int curr=it;
    int count=1;
    while(st.contains(curr+1)){
    count++;
    curr+=1;
    }
    maxLen=Math.max(count,maxLen);
    }
    } 
    return maxLen;
    }
}