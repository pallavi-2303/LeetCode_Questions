class Solution {
    public void makeHashMap(String str,HashMap<Character,Integer> mp) {
for(char ch:str.toCharArray()) {
mp.put(ch,mp.getOrDefault(ch,0)+1);
}
}
    public boolean isAnagram(String s, String t) {
        int n=s.length();
int m=t.length();
HashMap<Character,Integer> mp1=new HashMap<>();
HashMap<Character,Integer> mp2=new HashMap<>();
if(n!=m) return false;
makeHashMap(s,mp1);
makeHashMap(t,mp2);
return mp1.equals(mp2);
    }
}