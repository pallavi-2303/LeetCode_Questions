class Solution {
    public int calculate(String s) {
     int n=s.length();
int number=0;
int sign=1;
int res=0;
Stack<Integer> st=new Stack<>();
for(int i=0;i<n;i++){
char ch=s.charAt(i);
if(Character.isDigit(ch)) {
number*=10;
number+=(ch-'0');
}
else if(ch=='+') {
//number is previously calculated
res+=(number*sign);
sign=1;
number=0;
}
else if(ch=='-') {
res+=(number*sign);
sign=-1;
number=0;
}
else if(ch=='(') {
st.push(res);
st.push(sign);
res=0;
number=0;
sign=1;
}
else if(ch==')') {
res+=(number*sign);
int sig=st.pop();
int preresult=st.pop();
res=res*sig;
res+=preresult;
number=0;
}
}
res+=(number*sign);
return res;   
    }
}