class Solution {
    public String simplifyPath(String path) {
      String[] arr=path.split("/");
Stack<String> st=new Stack<>();
for(String str:arr) {
//if it is .. means previous directory needs to be popped
if(!st.isEmpty() && str.equals("..")) {
st.pop();
}
else if(!str.equals("") && !str.equals("..") && !str.equals(".")) {
st.push(str);
}
}
StringBuilder ans=new StringBuilder();
for(String str:st) {
ans.append("/");
ans.append(str);
}
return st.isEmpty() ? "/" : ans.toString();  
    }
}