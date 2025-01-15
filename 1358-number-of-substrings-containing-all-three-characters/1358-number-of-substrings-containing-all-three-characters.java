class Solution {
    public int numberOfSubstrings(String s) {
      //brute force generating all the sbstring and cheking whather they exit in given sting or not 
        int n=s.length();
        int count=0;
     /*  for(int i=0;i<n;i++){
         int[] check=new int[3];
           Arrays.fill(check,-1);
           for(int j=i;j<n;j++){
               char ch=s.charAt(j);
               check[ch-'a']=j;
               if(check[0]!=-1 && check[1] !=-1 && check[2]!=-1){
                   count++;
               }
           }
       }
        return count;//0(n2);*/
        //we have to stand at particular index find minium lenght where last is occuring because behind it all the the string will be valid
  int[] lastseen={-1,-1,-1} ;
    int r=0;
        while(r<n){
        char ch=s.charAt(r);
    lastseen[ch-'a']=r;
            if(lastseen[0]!=-1 && lastseen[1]!=-1 && lastseen[2]!=-1){
             count+=1+Math.min(lastseen[2],Math.min(lastseen[0],lastseen[1])) ;
            }
            r++;
        }
       return count; 
    }
}