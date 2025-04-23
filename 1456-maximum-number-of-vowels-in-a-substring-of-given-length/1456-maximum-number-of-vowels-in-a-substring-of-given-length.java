class Solution {
    public boolean isVowel(char ch){
return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u';
}
    public int maxVowels(String s, int k) {
      // int n=s.length();
// //generating all the subtring of length k
// int maxi=0;
// for(int i=0;i<=n-k;i++){
// int count=0;
// for(int j=i;j<i+k;j++){
// char ch=s.charAt(j);
// if(isVowel(ch)) {
// count++;
// }
// }
// maxi=Math.max(maxi,count);
// }
// return maxi; 
int n=s.length();
int count=0;
int maxi=0;
for(int i=0;i<k;i++){
char ch=s.charAt(i);
if(isVowel(ch)) {
count++;
}
}
maxi=count;
for(int i=k;i<n;i++){
char right=s.charAt(i);
char left=s.charAt(i-k);
if(isVowel(right)) count++;
if(isVowel(left)) count--;
maxi=Math.max(maxi,count);
}
return maxi;
    }
}