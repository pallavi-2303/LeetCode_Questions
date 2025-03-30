class Solution {
    public boolean isIsomorphic(String s, String t) {
      int n=s.length();
      int m=t.length();
      if(n!=m)  return  false;
      HashMap<Character,Character> mp=new HashMap<>();
      for(int i=0;i<n;i++){
    char sch=s.charAt(i);
    char tch=t.charAt(i);
    if(mp.containsKey(sch) && mp.get(sch)!=tch){
    return false;
    }
   else if(!mp.containsKey(sch) && mp.containsValue(tch)){
    return false;
    }
    else {
    mp.put(sch,tch);
    }
      }
      return true;
    }
}