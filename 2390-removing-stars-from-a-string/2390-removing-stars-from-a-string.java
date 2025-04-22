class Solution {
    public String removeStars(String s) {
    int n=s.length();
Stack<Character> st=new Stack<>();
for(int i=0;i<n;i++){
char ch=s.charAt(i);
if(ch=='*'){
if(!st.isEmpty()){
st.pop();}}
else {
st.push(ch);}}
StringBuilder str=new StringBuilder();
while(!st.isEmpty()){
str.append(st.pop());}
return str.reverse().toString();    
    }
}