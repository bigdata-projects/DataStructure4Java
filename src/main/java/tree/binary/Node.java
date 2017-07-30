package tree.binary;

/**
 * Created by Administrator on 2017/7/29.
 */
public class Node<E extends   Comparable> {
    //Data
    public E data;

    //left child Node
    public Node left;

    public Node right;

    public Node(E data){
        this.data = data;
    }
}
