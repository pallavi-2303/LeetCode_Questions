class Solution {
  public boolean isIsomorph(String s,String t) {
 HashMap<Character,Character> mp=new HashMap<>();
int n=s.length();
for(int i=0;i<n;i++) {
 char str=s.charAt(i);
 char ctr=t.charAt(i);
 if(mp.containsKey(str)) {
  if(mp.get(str)!=ctr) {
    return false;}}
 else if(mp.containsValue(ctr)) {
     return false;}
  else {
    mp.put(str,ctr);}}
      return true;}
 
    public boolean isIsomorphic(String s, String t) {
if(s.length()!=t.length()) {
  return false;}
    return isIsomorph(s,t);
        
    }
}