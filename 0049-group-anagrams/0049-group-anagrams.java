class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //we have to find valid anagrams we can sort all characters and put the string for every character 
HashMap<String,List<String>> mp=new HashMap<>();
for(String str:strs) {
//convert the string to character array and count its frequency 
int[] freq=new int[26];
for(char ch:str.toCharArray()) {
freq[ch-'a']++;
}
//Convert the freq to sorted array 
String key=Arrays.toString(freq);
//checking wheather this key is present in map or not
if(mp.containsKey(key)) {
List<String> temp=mp.get(key);
temp.add(str);
mp.put(key,temp);
}
else {
List<String> temp=new ArrayList<>();
temp.add(str);
mp.put(key,temp);
}
}
return new ArrayList(mp.values());
    }
}