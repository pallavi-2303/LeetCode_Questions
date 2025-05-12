class Solution {
    public int[] findEvenNumbers(int[] nums) {
       int n=nums.length;
//we have 10 digits only
//0 to 9
int[] mp=new int[10];
for(int num:nums) {
mp[num]++;
}
//since we have to form 3 digits number in which we can have no leading zeroes and digit should be divisible by 2
List<Integer> ans=new ArrayList<>();
for(int i=1;i<=9;i++){
if(mp[i]==0) continue;
mp[i]--;//this digit is used once for ith place
for(int j=0;j<=9;j++){
if(mp[j]==0) continue;
mp[j]--;
for(int k=0;k<=9;k++) {
if(mp[k]==0) continue;
mp[k]--;
int number=100*i+10*j+k;
if(number%2==0){
ans.add(number);
}
mp[k]++;
}
mp[j]++;
}
mp[i]++;
}
int[] arr=new int[ans.size()];
for(int i=0;i<ans.size();i++){
arr[i]=ans.get(i);
}
return arr; 
    }
}