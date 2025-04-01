class Solution {
    public boolean isValid(String s) {
    if(s.length()==0)   return true;
    Stack<Character> st=new Stack<>();
    for(char ch:s.toCharArray()){
if(ch=='(') st.push(')');
else if(ch=='[') st.push(']');
else if(ch=='{') st.push('}');
//else if it is a closing bracket
else if(st.isEmpty() || st.peek() !=ch) return false;
else {
st.pop();
}
    } 
    return st.isEmpty();
    }
}