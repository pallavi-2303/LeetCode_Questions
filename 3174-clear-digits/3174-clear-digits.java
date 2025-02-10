class Solution {
    public String clearDigits(String s) {
     //we will us a stringbuilder to delete the last value
     int n=s.length() ;
     StringBuilder sb=new StringBuilder();
     for(int i=0;i<n;i++) {
    if(!Character.isDigit(s.charAt(i))){
    sb.append(s.charAt(i));
    }
    else {
    //if it i the digit
    sb.deleteCharAt(sb.length()-1);
    }
     }
     return sb.toString();
    }
}