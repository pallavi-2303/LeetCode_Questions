class Solution {
    public boolean deleteSenagate(StringBuilder str,char ch,int idx){
boolean left=false;
while(true){
if(idx==0) left=true;
if(str.charAt(idx)==ch){
str.deleteCharAt(idx);
break;}
idx=(idx+1)%str.length();}
return left;}
    public String predictPartyVictory(String senate) {
        //Since each candidate is clever is will try to delete his nearest non party neighbours so that he can not cancel him and if last index finishes he can move circularly
StringBuilder str=new StringBuilder(senate);
int Rcount=0;
int Dcount=0;
for(char ch:senate.toCharArray()){
if(ch=='R') Rcount++;}
Dcount=senate.length()-Rcount;
int idx=0;
while(Rcount>0 && Dcount>0){
if(str.charAt(idx)=='R'){
boolean left=deleteSenagate(str,'D',(idx+1)%str.length());
Dcount--;
if(left) idx--;}
else {
boolean left=deleteSenagate(str,'R',(idx+1)%str.length());
Rcount--;
if(left) idx--;}
//Now increase the count
idx=(idx+1)%str.length();}
return Rcount==0 ? "Dire" : "Radiant";
    }
}