class Solution {
    public int findGCD(int a,int b){
    while(b!=0){
    int temp=b;
    b=a%b;
    a=temp;
    }
    return a;
    }
    public String gcdOfStrings(String str1, String str2) {
    //the divisor is ossible if x can be repeated to construct str1 and tsr2
    if(!(str1+str2).equals(str2+str1)){
    return "";
    }
int  longestGCD=findGCD(str1.length(),str2.length());
return str1.substring(0,longestGCD);
    }
}