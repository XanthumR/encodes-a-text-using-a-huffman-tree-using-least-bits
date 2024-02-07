public class TNode <T extends Comparable>{
    public Integer value;
    public String letter;
    public TNode<T> left, right,next;

    public TNode(Integer val){
        this.value=-1;
        this.left=null;
        this.right=null;
        this.next=null;
        this.letter="";
    }
    public String toString(){
        return String.valueOf(value);
    }
}