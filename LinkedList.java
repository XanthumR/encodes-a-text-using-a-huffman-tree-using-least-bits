import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class LinkedList<T extends Comparable> {
    private Node<T> head;

    public Node<T> createNode(T val){
        return new Node<T>(val,0);
    }
    public void sort(LinkedList<T> linked){
        Node<T> iterator=head;

        while(iterator!=null){
            linked.sortedInsert(iterator);
            iterator=iterator.next;
    }
    }

    public Node<T> subTree(Node<T> first,Node<T> second){
        int f= first.freq;
        int s =second.freq;
        Node<T> newNode=new Node<>(null,f+s);
        if (f> s){
            newNode.right=first;
            newNode.left=second;
        } else{
            newNode.left=first;
            newNode.right=second;
        }


        return newNode;
    }

    public HuffmanTree<T> huffmanTree(){
        HuffmanTree<T> freqTree= new HuffmanTree<>();
        Node<T> iterator=head;
        Node<T> subtree;
        subtree=subTree(iterator,iterator.next);
        iterator=iterator.next.next;
        head=iterator;
        sortedInsertforhuffmantree(subtree);
        while (iterator!=null){
            iterator=head;
            subtree=subTree(iterator,iterator.next);
            iterator=iterator.next.next;
            head=iterator;
            sortedInsertforhuffmantree(subtree);
        }
        freqTree.setRoot(head);
return freqTree;
    }
    public void sortedInsertforhuffmantree(Node<T> newNode){
        if(head==null){
            head=newNode;}
        else if (newNode.freq<=head.freq){
            newNode.next=head;
            head=newNode;
        }else{
            Node<T> iterator=head;
            while(iterator.next!=null && iterator.next.freq<newNode.freq){
                iterator=iterator.next;
            }
            newNode.next=iterator.next;
            iterator.next=newNode;
        }
    }
    public void sortedInsert(Node<T> newNode){
        Node<T> newNode1=new Node<>(newNode.value, newNode.freq);
        if(head==null){
            head=newNode1;}
        else if (newNode1.freq<=head.freq){
            newNode1.next=head;
            head=newNode1;
        }else{
            Node<T> iterator=head;
            while(iterator.next!=null && iterator.next.freq<newNode1.freq){
                iterator=iterator.next;
            }
            newNode1.next=iterator.next;
            iterator.next=newNode1;
        }
    }
    public void searchChar(T string){
        if(head==null){
            return;
        }
        Node<T> iterator=head;
        while(iterator!=null){
            if (iterator.value.equals(string)){
                ++iterator.freq;
            }
            iterator=iterator.next;
        }


    }
    public void insertToFront(T val){
        Node<T> newNode=createNode(val);
        newNode.next=head;
        head=newNode;
    }
    public void insertToFront1(Node<T> newNode){
        newNode.next=head;
        head=newNode;
    }
    public void display(){
        Node<T> iterator=head;
        while(iterator!=null){
            System.out.print(" "+iterator.value+ ":"+iterator.freq);
            iterator=iterator.next;
        }
        System.out.println();

    }
    public void displayCodes(){
        Node<T> iterator=head;
        while(iterator!=null){
            System.out.print(" "+iterator.value+":"+iterator.a);
            iterator=iterator.next;
        }
        System.out.println();

    }
    public Node<T> find(T val){
        Node<T> iterator = head;
        while (iterator!=null){
            if (iterator.value.compareTo(val)==0){

                return iterator;
            }
            iterator=iterator.next;
        }
        return null;
    }
    public boolean search(T val){
        Node<T> iterator = head;
        while (iterator!=null){
            if (iterator.value.compareTo(val)==0){

                return true;
            }
            iterator=iterator.next;
        }
        return false;
    }
}