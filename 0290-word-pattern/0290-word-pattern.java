class Solution {
    public boolean wordPattern(String pattern, String s) {
      String[] words=s.split(" ");
if(words.length!=pattern.length()) {
return false;
}
HashMap<Character,String> mp=new HashMap<>();
for(int i=0;i<pattern.length();i++){
char ch=pattern.charAt(i);
String word=words[i];
//if this chracter if alrready present and mapped to someone else
if(mp.containsKey(ch) && !mp.get(ch).equals(word)){
return false;
}
//if this value is  llaredy mapped to another chracter and we are mapping it to another character
else if(!mp.containsKey(ch) && mp.containsValue(word)){
  return false;  
}
else {
mp.put(ch,word);
}
}
return true;  
    }
}