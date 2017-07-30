package linear.list.single;

/**
 * Created by Administrator on 2017/7/28.
 */

/**
 * 自定义链表，非线程安全
 *
 * @param <E>
 */
public class LinkList<E> {
    //head
    private Node<E> head;

    public LinkList() {
        head = null;
    }

    /**
     * 插入一个节点，在头节点镜像插入
     *
     * @param value
     */
    public void insertFirst(E value) {
        Node node = new Node(value);
        if (null == head) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    /**
     * 删除一个节点，在头节点进行删除
     *
     * @return
     */
    public Node removeFirst() {
        Node tmp = head;
        if(null != head){
            head = tmp.next;
        }

        return tmp;
    }


    /**
     * 查找
     * @param element
     * @return
     */
    public Node element(E element){
        Node current = head;
        Node tmp = null;
        while (null != current){
            if (current.data.equals(element)){
                tmp = current;
                break;
            }
            current = current.next;
        }
        return tmp;
    }

    public Node remove(E element){
        Node current = head;
        Node previous = head;
        Node tmp = null;
        while (null != current){
            if (current.data.equals(element)){
                tmp = current;
                if (current == head){
                    head = head.next;
                }else{
                    previous.next = current.next;
                }
                break;
            }else{
                previous = current;
                current = current.next;
            }

        }

        return tmp;
    }
    public void traverse() {

    }

    public int size() {
        int count = 0;
        Node current = head;
        while (null != current) {
            count++;
            current = current.next;
        }
        return count;
    }


    public boolean isEmpty() {
        return null == head;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            current.display();
            current = current.next;
        }
    }

    public static void main(String[] args) {
        LinkList linkList = new LinkList<Integer>();
        linkList.insertFirst(new Integer(10));
        linkList.insertFirst(new Integer(12));
        linkList.insertFirst(new Integer(13));
        Node node = linkList.element(new Integer(12));
        System.out.println(node.data);
        //linkList.removeFirst();
        linkList.remove(new Integer(13));
        linkList.display();
        System.out.println(linkList.size());
    }
}
