public class HuffmanTree <T extends Comparable>{
    private Node<T> root;
    public LinkedList<T> codes=new LinkedList<>();

public void setRoot(Node<T> val){
    root=val;
}
    public void test(){
        System.out.println(root.value);
    }



    public String decode(String[] stringArray){
        Node<T> iterator= root;
        String decoded="";
            for (String c:stringArray){
                if (c.contains("0")){
                    iterator=iterator.left;
                }
                else if (c.contains("1")){
                    iterator=iterator.right;
                }
                if (iterator.isLeaf()){
                    decoded=decoded+iterator.value;
                    iterator=root;
                }
            }
        return decoded;
    }
    public boolean checker(String code){
        Node<T> iterator= root;
        for (int i=0;i<code.length();i++){
            if (code.charAt(i)=='0'&&iterator.left!=null){
                iterator=iterator.left;
            }
            else if (code.charAt(i)=='1'&&iterator.right!=null){
                iterator=iterator.right;
            }
            else {
                return false;
            }
        }
return true;
    }
    public void findCodes(){
        findCodes(root,"");
    }
    public void findCodes(Node<T> root,String code){
        if (root.isLeaf()){
            Node<T> node = new Node<>(root.value,0);
            node.a=code;
            codes.insertToFront1(node);
            return;
        }
        findCodes(root.left,code.concat("0"));
        findCodes(root.right,code.concat("1"));

    }
}



