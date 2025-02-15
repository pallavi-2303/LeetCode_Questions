class Solution {
public boolean isPartition(String str,int j,int i,int currsum){
int n=str.length();
if(j==n){
return currsum==i;
}
//try to partition at each indexes
for(int idx=j;idx<n;idx++){
//partion from idx to j last value is not included
int val=Integer.parseInt(str.substring(j,idx+1));
if(isPartition(str,idx+1,i,currsum+val)){
return true;
}
}
return false;
}
    public int punishmentNumber(int n) {
    int sum=0;
    for(int i=1;i<=n;i++){
String square=Integer.toString(i*i);
if(isPartition(square,0,i,0)){
sum+=i*i;
}
    } 
    return sum;  
    }
}