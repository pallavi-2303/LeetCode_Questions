class Solution {
    public int calc(int a,int b,String o){
    int res=0;
    switch(o){
      case "+"->res=a+b;
       case "-"->res=a-b;  
        case "*"->res=a*b;  
         case "/"->res=a/b;    
    }
    return res;
    }
    public boolean isOperator(String s){
String str="*/-+";
if(str.contains(s)){
return true;}
else return false;}
    public int evalRPN(String[] tokens) {
        Stack<String> st=new Stack<>();
for(String s:tokens){
if(!isOperator(s)){
st.push(s);}
else {
//If it is a operator
int b=Integer.parseInt(st.pop());
int a=Integer.parseInt(st.pop());
int res=calc(a,b,s);
st.push(Integer.toString(res));}}
return Integer.parseInt(st.peek());
    }
}