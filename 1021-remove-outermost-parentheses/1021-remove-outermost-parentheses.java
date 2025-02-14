class Solution {
    public String removeOuterParentheses(String s) {
       //brute force by suing a stack
       Stack<Character> st=new Stack<>();
       String ans="";
       for(char ch:s.toCharArray()) {
    if(ch=='('){
if(st.size()>0){
ans+=ch;
}
st.push(ch);
    }
    else {
    //it is the closing bracket
    st.pop();
  if(st.size()>0) {
ans+=ch;
  } 
    }
       }
       return ans;
    }
}