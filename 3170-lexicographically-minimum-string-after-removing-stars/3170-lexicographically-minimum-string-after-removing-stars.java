class Solution {
    public class pair {
        char ch;
        int index;

        public pair(char ch, int index) {
            this.ch = ch;
            this.index = index;
        }
    }

    public String clearStars(String s) {

        //PriorityQueue to store ch , index

        PriorityQueue<pair> pq = new PriorityQueue<>(
                (a, b) -> a.ch != b.ch ? Character.compare(a.ch, b.ch) : Integer.compare(b.index, a.index));
        char[] arr = s.toCharArray();
        int n = arr.length;
        //tc-> nlogn+n sc-> O(2n);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '*') {
                pq.add(new pair(arr[i], i));
            } else {
                //if it is a start charater mark the lowest ch to start
                pair it = pq.poll();
                char ch = it.ch;
                int idx = it.index;
                arr[idx] = '*';
            }
        }
        StringBuilder str = new StringBuilder();
        //putting all String 
        for (int i = 0; i < n; i++) {
            if (arr[i] != '*') {
                str.append(arr[i]);
            }
        }
        return str.toString();
    }
}