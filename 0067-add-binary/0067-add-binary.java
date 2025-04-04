class Solution {
    public String addBinary(String a, String b) {
   if(b.length()>a.length()) {
String temp=a;
a=b;
b=temp;
   }
   while(b.length()<a.length()) 
   b="0"+b;
StringBuilder res=new StringBuilder();
int carry=0;
for(int i=b.length()-1;i>=0;i--){
char bch=b.charAt(i);
char ach=a.charAt(i);
if(bch=='1' && ach=='1'){
if(carry==0) {
res.append('0');
carry=1;
}
else {
res.append('1');
carry=1;
}
}
else if((ach=='0' && bch=='1') || (ach=='1' && bch=='0')){
if(carry==1){
res.append('0');
carry=1;
}
else{
res.append('1');
}
}
else {
if(carry==1) {
res.append('1');
carry=0;
}
else res.append('0');
}
}
if(carry==1) res.append(carry);
return res.reverse().toString();
    }
}