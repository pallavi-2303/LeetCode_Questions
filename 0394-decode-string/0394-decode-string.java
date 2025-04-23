class Solution {
    public String decodeString(String s) {
      Stack<String> stringStack=new Stack<>();
Stack<Integer> number=new Stack<>();
int k=0;
for(char ch:s.toCharArray()){
//If the character is a digit
if(Character.isDigit(ch)){
k=k*10+ch-'0';
continue;}
//if it is opening bracket 
if(ch=='['){
number.push(k);
k=0;
stringStack.push(String.valueOf(ch));
continue;}
if(ch!=']'){
stringStack.push(String.valueOf(ch));
continue;}
//If it is closing bracket 
int count=number.pop();
StringBuilder temp=new StringBuilder();
while(!stringStack.peek().equals("[")){
temp.insert(0,stringStack.pop());}
stringStack.pop();//remove the opening bracket
StringBuilder replacement=new StringBuilder();
for(int i=0;i<count;i++){
replacement.insert(0,temp);}
stringStack.push(replacement.toString());
}
StringBuilder res=new StringBuilder();
while(!stringStack.isEmpty()){
res.insert(0,stringStack.pop());}
return res.toString();  
    }
}