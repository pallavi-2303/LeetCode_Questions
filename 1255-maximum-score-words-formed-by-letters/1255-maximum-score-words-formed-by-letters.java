class Solution {
    //leetcode 1255
//TC->2^N *len of one word
//Sc->26*n;
public void findScore(int idx,int[] maxScore,int currScore,String[] words,int[] freq,int[] score) {
int n=words.length;
maxScore[0]=Math.max(maxScore[0],currScore);
if(idx>=n) {
//we have explored possibilities of every word
return;
}
//at perticular word we can take that or not take that
int j=0;
int[] temp = Arrays.copyOf(freq, 26);
int len=words[idx].length();
int currscore=0;
while(j<len) {
char ch=words[idx].charAt(j);
temp[ch-'a']--;
currscore+=score[ch-'a'];
if(temp[ch-'a']<0) break; // we cantnot form this word
j++;
} 
if(j==len){
//we can take this word
findScore(idx+1, maxScore,currScore+currscore,words,temp,score);
}
//backyracking ki jagah humne temp freq array liya h 
//if we dont take the this particular word
findScore(idx+1, maxScore,currScore,words,freq,score);
}
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
      
int[] freq=new int[26];
for(char ch:letters){
freq[ch-'a']++;
}
int[] maxScore={Integer.MIN_VALUE};
findScore(0,maxScore,0,words,freq,score);
return maxScore[0];  
    }
}