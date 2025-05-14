class Solution {
private int size=26;
private int M=(int)1e9+7;
    public int[][] matrixMultiplication(int[][] a,int[][] b){
int[][] res=new int[size][size];
for(int i=0;i<size;i++){
for(int j=0;j<size;j++){
long sum=0;
for(int k=0;k<size;k++){
sum = (sum+1L*a[i][k]*b[k][j])%M;

}
res[i][j]=(int)sum;
}
}
return res;
}
public int[][] matrixExponent(int[][] base,int exponent){
int[][] identity=new int[size][size];
for(int i=0;i<26;i++){
identity[i][i]=1;
}
if(exponent==0) return identity;
int[][] half=matrixExponent(base,exponent/2);
int[][] result=matrixMultiplication(half,half);
if(exponent%2==1){
result=matrixMultiplication(result,base);
}
return result;
}
    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
       int[] freq=new int[size];
for(char ch:s.toCharArray()){
freq[ch-'a']++;
}
//if we want to find final frequency we can find by fq=(T,t)*inialfreq
int[][] T=new int[size][size];
//making initial T matrix
for(int i=0;i<size;i++){
for(int add=1;add<=nums.get(i);add++){
int newIdx=(i+add)%size;
T[newIdx][i]=(T[newIdx][i]+1)%M;
}
}
int[][] result=matrixExponent(T,t);
//now to get final frequency array we have to multiply result to initial freq

int[] updatedFreq=new int[26];
for(int i=0;i<size;i++){
long val=0;
for(int j=0;j<size;j++){
val=(val+1L*result[i][j]*freq[j])%M;
}
updatedFreq[i]=(int)val;
}
int totalFreq=0;
for(int fre:updatedFreq){
totalFreq=(totalFreq+fre)%M;
}
return totalFreq; 
    }
}