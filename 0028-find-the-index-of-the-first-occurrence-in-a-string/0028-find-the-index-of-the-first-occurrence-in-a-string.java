class Solution {
    public void findLPS(int[] lps,String s) {
lps[0]=0;
int n=s.length();
int len=0;
int i=1;
while(i<n) {
if(s.charAt(i)==s.charAt(len)) {
len++;
lps[i]=len;
i++;
}
else {
if(len!=0){
len=lps[len-1];
}
else {
lps[i]=0;
i++;
}
}
}}
    public int strStr(String s, String pattern) {
    int ans=-1;
int n=s.length();
int m=pattern.length();
if(m>n) return -1;
int[] lps=new int[m];
findLPS(lps,pattern);
int i=0;
int j=0;
while(i<n) {
if(s.charAt(i)==pattern.charAt(j)){
i++;
j++;
}
if(j==m) {
ans=i-j;
break;
//j=lps[j-1];
}
else if(i< n && s.charAt(i)!=pattern.charAt(j)) {
if(j!=0) {
j=lps[j-1];
}
else {
i++;
}
}
}
return ans;
    }
}