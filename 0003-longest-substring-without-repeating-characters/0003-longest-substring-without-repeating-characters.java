class Solution {
    public int lengthOfLongestSubstring(String s) {
     int n=s.length();
     int maxLen=0;
//      for(int i=0;i<n;i++) {
//     HashSet<Character> st=new HashSet<>();
//     for(int j=i;j<n;j++){
// if(st.contains(s.charAt(j))){
// maxLen=Math.max(maxLen,j-i);
// break;
// }
// st.add(s.charAt(j));
//     }
//      }  
//      return  maxLen;
HashMap<Character,Integer> mp=new HashMap<>();
int l=0;
int  r=0;
while(r<n){
char ch=s.charAt(r);
while(mp.containsKey(ch)){
char tch=s.charAt(l);
mp.remove(tch);
l++;
}
maxLen=Math.max(maxLen,r-l+1);
r++;
mp.put(ch,r);
}
return maxLen;
    }
}