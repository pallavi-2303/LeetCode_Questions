class Solution {
    public long countGoodIntegers(int n, int k) {
     //since we have to count the combination of every string we will try to findout  a string and count all permutaions by taking left half and making it pallindrome
int d=(n+1)/2;
int start=(int) Math.pow(10,d-1) ;
int end=(int)Math.pow(10,d)-1;
HashSet<String> st=new HashSet<>();
for(int num=start;num<=end;num++){
String leftSide=Integer.toString(num);
String full;
if(n%2==0){
StringBuilder right=new StringBuilder(leftSide).reverse();
full=leftSide+right.toString();
}
else {
StringBuilder right=new StringBuilder(leftSide.substring(0,d-1)).reverse();
full=leftSide+right.toString();
}
long number=Long.parseLong(full);
if(number%k!=0) continue;
//we have to store the elelemts by sorting it
char[] charArray=full.toCharArray();
Arrays.sort(charArray);
st.add(new String(charArray));
}
//let us precalculate the factoral of all the numbers from 0 to 10
long[] factorial=new long[11];
factorial[0]=1;
for(int i=1;i<11;i++){
 factorial[i]=factorial[i-1]*i;}
 //iterating all the characetrs of set and find out all the coninations and also devide by permuation of reprating numbers
 long result=0;
 for(String str:st) {
int[] count=new int[10];
for(char ch:str.toCharArray()){
count[ch-'0']++;
}
int totlength=str.length();
int zero=count[0];
int nonzero=totlength-zero;
long permutation=nonzero*factorial[totlength-1];
//devide by reprating chracters
for(int i=0;i<10;i++){
permutation/=factorial[count[i]];
}
result+=permutation;
 } 
 return result;
    }
}