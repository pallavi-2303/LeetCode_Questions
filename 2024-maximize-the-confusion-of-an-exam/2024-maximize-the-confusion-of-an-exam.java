class Solution {
    public int solve(String answerKey,char ch,int k){
    int n=answerKey.length();
    //given charcter ka max k ocoorence hone chahiye in given subarray
int maxLen=0;
int l=0;
int r=0;
int count=0;
while(r<n){
if(answerKey.charAt(r)==ch){
count++;
}
if(count>k){
if(answerKey.charAt(l)==ch){
count--;
}
l++;
}
maxLen=Math.max(maxLen,r-l+1);
r++;
}
return maxLen;
    }
     public int solve2(String answerKey,int k){
    int maxLen=0;
int l=0;
int r=0;
 int n=answerKey.length();
HashMap<Character,Integer> mp=new HashMap<>();
while(r<n){
char ch=answerKey.charAt(r);
mp.put(ch,mp.getOrDefault(ch,0)+1);
//if invald window 
while(Math.min(mp.getOrDefault('T',0),mp.getOrDefault('F',0))>k){
//shrink from left
char tch=answerKey.charAt(l);
mp.put(tch,mp.get(tch)-1);
l++;
}
maxLen=Math.max(maxLen,r-l+1);
r++;
} 
return maxLen;  
     }
    public int maxConsecutiveAnswers(String answerKey, int k) {
    //max streak of given character with atmost particular charcter
   // return Math.max(solve(answerKey,'T',k),solve(answerKey,'F',k)) ;  
   return solve2(answerKey,k) ;
    }
}