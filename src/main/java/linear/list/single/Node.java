package linear.list.single;

/**
 * Created by Administrator on 2017/7/28.
 */
public class Node<E> {
    //数据域
    public E data;

    //指针域
    public Node next;

    public Node(E data) {
        this.data = data;
    }

    public void display(){
        System.out.println(data.toString());
    }
}
