class Solution {
    public String largestOddNumber(String num) {
        int n=num.length();
int i=n-1;
while(i>=0) {
 int dig=num.charAt(i)-'0';
 if(dig%2!=0) {
 return num.substring(0,i+1);
 }
i--;}
return "";
    }
}