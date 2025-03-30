class Solution {
    public void makeHashMap(String str,HashMap<Character,Integer> mp){
    for(char ch:str.toCharArray()){
    mp.put(ch,mp.getOrDefault(ch,0)+1);
    }
    }
    public boolean canConstruct(String ransomNote, String magazine) {
       HashMap<Character,Integer> mp1=new HashMap<>();
       HashMap<Character,Integer> mp2=new HashMap<>();
       makeHashMap(ransomNote,mp1);
        makeHashMap(magazine,mp2);
        for(char ch:ransomNote.toCharArray()){
        if(!mp2.containsKey(ch)) return false;
   else if(mp2.containsKey(ch) && mp2.get(ch)<mp1.get(ch)){
return false;
   }
        }
       return true;
       
    }
}