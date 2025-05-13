class Solution {
int M=(int)1e9+7;
    public int lengthAfterTransformations(String s, int t) {
     int n=s.length();
int[] mp=new int[26];
for(char ch:s.toCharArray()){
mp[ch-'a']++;
}
while(t>0){
int[] temp=new int[26];
for(int i=0;i<26;i++){
char ch=(char)(i+'a');
int freq=mp[i];
if(ch!='z') {
temp[(ch+1)-'a']=(temp[(ch+1)-'a']+freq)%M;
}
else {
//if it is z
temp['a'-'a']=(temp['a'-'a']+freq)%M;
temp['b'-'a']=(temp['b'-'a']+freq)%M;
}
}
mp=temp;
t--;
}
int result=0;
for(int i=0;i<26;i++){
result+=mp[i]%M;
}
return result;   
    }
}