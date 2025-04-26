class SmallestInfiniteSet {
    boolean[] arr;
    int i;

    public SmallestInfiniteSet() {
        arr = new boolean[1000 + 1];
        Arrays.fill(arr, true);
        i = 1;
    }

    public int popSmallest() {
        int result = i;
        arr[i] = false;
        for (int j = i + 1; j <= 1000; j++) {
            if (arr[j] == true) {
                i = j;
                break;
            }
        }
        return result;
    }

    public void addBack(int num) {
        //only add back if it was popped 
        if(!arr[num]){
        arr[num]=true;
        if(num<i)
        i=num;
        }
       
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */