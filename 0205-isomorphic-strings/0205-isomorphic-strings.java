class Solution {
    public boolean IsIsomorphic(String s,String t){
      HashMap<Character,Character> mp=new HashMap<>();
      for(int i=0;i<s.length();i++) {
    //so we are maping s to t
     char sch=s.charAt(i);
     char tch=t.charAt(i);
    if(mp.containsKey(sch)){
    if(mp.get(sch)!=tch){
     return false;
    }}
    else if(mp.containsValue(tch)){
        return false;
    }
    else {
        mp.put(sch,tch);
    }
      }
      return true;//if all the mapping is done
    }
    public boolean isIsomorphic(String s, String t) {
       //we will map one chracater of string s to  another character of string character
       int n1=s.length();
       int n2=t.length();
      if(n1!=n2) return false;
      return IsIsomorphic(s,t);
    }
}