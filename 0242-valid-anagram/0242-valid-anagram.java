class Solution {
  public HashMap<Character,Integer> MakeHashMap(String s) {
 HashMap<Character,Integer> mp=new HashMap<>();
for(int i=0;i<s.length();i++) {
 char ch=s.charAt(i);
 mp.put(ch,mp.getOrDefault(ch,0)+1);}
    return mp;}
 public boolean isAnagram2(String s,String t) {
 HashMap<Character,Integer> mp1=MakeHashMap(s);
HashMap<Character,Integer> mp2=MakeHashMap(t);
  return mp1.equals(mp2);}
    public boolean isAnagram(String s, String t) {
if(s.length()!=t.length()) {
 return false;}
  return isAnagram2(s,t);
        
    }
}