class Solution {
    public int myAtoi(String s) {
        //To reduce leading white spaces trim the string
if(s==null) return 0;
s=s.trim();
if(s.length()==0) return 0;
int min=Integer.MIN_VALUE;
int max=Integer.MAX_VALUE;
int sign=1;
long ans=0;
if(s.charAt(0)=='-'){
sign=-1;}
int i=s.charAt(0)=='-' || s.charAt(0)=='+' ? 1:0;
while(i<s.length()){
char ch=s.charAt(i);
if(!Character.isDigit(ch)){
break;}
ans=ans*10+ch-'0';
if(sign==-1 && ans*sign<min) return min;
if(sign==1 && sign*ans>max) return max;
i++;}
return (int) ans*sign;
    }
}