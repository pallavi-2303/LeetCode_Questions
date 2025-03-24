class Solution {
    public List<Integer> generateCols(int row){
    List<Integer> temp=new  ArrayList<>();
    int ans=1;
    temp.add(ans);
    for(int col=1;col<row;col++){
    ans=ans*(row-col)/col;
    temp.add(ans);
    }
    return temp;
    }
    public List<List<Integer>> generate(int numRows) {
     List<List<Integer>> res=new ArrayList<>() ;
      for(int row=1;row<=numRows;row++){
    res.add(generateCols(row));
      }
      return res;
    }
}