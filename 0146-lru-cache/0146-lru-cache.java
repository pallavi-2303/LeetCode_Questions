class LRUCache {
Node head=new Node(0,0);
 Node tail=new Node(0,0);
 HashMap<Integer,Node> mp=new HashMap<>();
   int capacity;
    public LRUCache(int _capacity) {
  head.next=tail;
   tail.prev=head;
     capacity=_capacity;
        
    }
    
    public int get(int key) {
   if(mp.containsKey(key)) {
   Node node=mp.get(key);
     remove(node);
      insert(node);
     return node.value; }
      else {
        return -1;}
    }
    
    public void put(int key, int value) {
   if(mp.containsKey(key)) {
  remove(mp.get(key));}
   if(mp.size()==capacity) {
    remove(tail.prev);}
  insert(new Node(key,value)); 
    }
  public void remove(Node node) {
  mp.remove(node.key);
  node.prev.next=node.next;
   node.next.prev=node.prev;}
  public void insert(Node node) {
  mp.put(node.key,node);
 Node headNext=head.next;
  head.next=node;
   headNext.prev=node;
    node.next=headNext;
    node.prev=head;}
  
 public class Node {
  Node next;
  Node prev;
  int key;
 int value;
     Node(int _key,int _value) {
    key=_key;
     value=_value;
         }}
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */