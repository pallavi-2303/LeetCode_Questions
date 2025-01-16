class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
int maxlen=0;
//brute force -> We will try to keep that portion inact that has maiximum frequency and change that apears less time 
//generating all the substring
for(int i=0;i<n;i++){
HashMap<Character,Integer> mp=new HashMap<>();
int maxfreq=0;

for(int j=i;j<n;j++){
 char ch=s.charAt(j);
 mp.put(ch,mp.getOrDefault(ch,0)+1);
 maxfreq=Math.max(maxfreq,mp.get(ch));
 if(((j-i+1)-maxfreq)<=k) {
 maxlen=Math.max(maxlen,j-i+1);
 }
 else if(((j-i+1)-maxfreq)>k){
  break;
 }
}}
return maxlen;

    }
}