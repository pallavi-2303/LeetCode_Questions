class Solution {
    public boolean closeStrings(String word1, String word2) {
      //since we can only transform characters the characters in both words need to be same and since one character can be changed to other the frequencies of character need to be same of one or other one
int[] freq1=new int[26];
int[] freq2=new int[26];
for(char ch:word1.toCharArray()){
freq1[ch-'a']++;
}
for(char ch:word2.toCharArray()){
freq2[ch-'a']++;
}
for(int i=0;i<26;i++){
if((freq1[i]==0 && freq2[i]==0) || (freq1[i]!=0 && freq2[i]!=0)){
continue;
}
return false;
}
Arrays.sort(freq1);
Arrays.sort(freq2);
return Arrays.equals(freq1,freq2);  
    }
}