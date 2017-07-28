package linear.queue;

/**
 * Created by Administrator on 2017/7/27.
 */

/**
 * 线程不安全
 */
public class CustQueue {
    private int[] queue;

    private int size;

    private int front;

    private  int end;

    public CustQueue() {
        this.queue = new int[10];
        size = 0;
        front = 0;
        end = -1;
    }

    public CustQueue(int size) {
        this.queue = new int[size];
        size = 0;
        front = 0;
        end = -1;
    }

    public void queue(int elem){
        //判断队列满
        queue[++end] = elem;
        this.size++;
    }

    public int dequeue(){
        //
        this.size--;
        return queue[front++];
    }

    public int peek(){
        return queue[front];
    }

    public boolean isEmpty(){
        return 0 == size;
    }

    public boolean isFull(){
        return queue.length == size;
    }

    public static void main(String[] args){
        CustQueue queue = new CustQueue(3);
        queue.queue(1);
        queue.queue(2);
        queue.queue(3);
        System.out.println(queue.isFull());
    }
}
