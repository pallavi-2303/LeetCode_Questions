class Solution {
    public int lengthOfLongestSubstring(String s) {
       HashSet<Character> st=new HashSet<>();
int n=s.length();
int l=0;
int r=0;
int maxi=0;
while(r<n){
char ch=s.charAt(r);
while(st.contains(ch)) {
char tch=s.charAt(l);
st.remove(tch);
l++;}
maxi=Math.max(maxi,r-l+1);
st.add(ch);
r++;} 
return maxi;
    }
}