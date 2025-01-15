class Solution {
    public int lengthOfLongestSubstring(String s) {
       int n=s.length();
       //brute force generating all the subarray and fining max of all
       int maxlen=0;
       for(int i=0;i<n;i++){
    HashSet<Character> st=new HashSet<>();
    for(int j=i;j<n;j++){
     char ch=s.charAt(j);
     if(!st.contains(ch)){
        st.add(ch);
        maxlen=Math.max(maxlen,j-i+1);
     }
     else {
        break;
     }

    }
       }
       return maxlen;
       
    }
}