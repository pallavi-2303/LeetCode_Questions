class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    List<Boolean> ans=new ArrayList<>();
 int n=candies.length;
 //if a kid can have  greater candy than the maximum number of candies among all the children he wil definetely have the greater than all the other kids
 int maxi=0;
 for(int num:candies){
maxi=Math.max(num,maxi);
 }
for(int num:candies){
if(num+extraCandies>=maxi){
ans.add(true);
}
else {
ans.add(false);
}
}
return ans;

    }
}