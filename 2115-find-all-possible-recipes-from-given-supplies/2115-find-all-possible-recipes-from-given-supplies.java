class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
    int n=recipes.length;
    //we have to tell which recipy is possible that's why we will try out al possible recipes and check whther this recipy can be made or not
    //we have to make total n iteration to find out which recipy can we made from which
int count=n;
HashSet<String> st=new HashSet<>();
for(String it:supplies) st.add(it);
boolean[] made=new boolean[n];
List<String> res=new ArrayList<>();
while(count>0){
for(int i=0;i<n;i++){
if(made[i]){
continue;
}
boolean flag=true;
for(String ingri:ingredients.get(i)){
if(!st.contains(ingri)){
flag=false;
break;
}
}
if(flag){
//all indrients are present htis can be made 
res.add(recipes[i]);
made[i]=true;
st.add(recipes[i]);//add this recipy to ingridients;
}
}
count--;
}
return res;

    }
}