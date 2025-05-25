class Solution {
    public int longestPalindrome(String[] words) {
     int n=words.length;
HashMap<String,Integer> mp=new HashMap<>();
int result=0;
for(String word:words){
String reverseWord=new StringBuilder(word).reverse().toString();
if(mp.containsKey(reverseWord) && mp.get(reverseWord)>0){
 result+=4;   
 mp.put(reverseWord,mp.get(reverseWord)-1);
}
else{
mp.put(word,mp.getOrDefault(word,0)+1);
}
}

for(Map.Entry<String,Integer> entry:mp.entrySet()) {
String word=entry.getKey();
int count=entry.getValue();
if(word.charAt(0)==word.charAt(1) && count>0){
result+=2;
break;
}
}
return result;   
    }
}