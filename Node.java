public class Node<T extends Comparable> {
    public T value;
    public int freq;
    public Node<T> left, right,next;
    public String a;
    public Node(T val,int freq1){
        this.value=val;
        this.left=null;
        this.right=null;
        this.next=null;
        this.freq=freq1;
        this.a=null;
    }
    public boolean isLeaf(){
        return left == null && right == null;

    }

    public String toString(){
        return String.valueOf(value);
    }
}