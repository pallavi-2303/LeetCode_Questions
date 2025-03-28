class Solution {
    public String convert(String s, int numRows) {
     //we will first make string array of numrows
     int n=s.length();
     String[] ans=new String[numRows];
     for(int i=0;i<numRows;i++) {
    ans[i]="";
     } 
    int i=0;
while(i<n){
//moving from up too  down
for(int idx=0;idx<numRows && i<n ;idx++){
ans[idx]+=s.charAt(i++);
}
//moving from bottom to top
for(int idx=numRows-2;idx>0 && i<n ;idx--){
ans[idx]+=s.charAt(i++);
}
}

String res="";
for(String str:ans){
res+=str;
}
return res;
    }
}