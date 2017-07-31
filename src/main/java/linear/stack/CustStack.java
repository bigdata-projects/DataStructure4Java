package linear.stack;

import org.omg.CORBA.Object;

/**
 * Created by Administrator on 2017/7/27.
 */

/**
 * 线程不安全
 */
public class CustStack {
    private int[] items;

    private int top;

    public CustStack() {
        this.items = new int[100];
        this.top = -1;
    }

    public CustStack(int size) {
        this.items = new int[size];
        this.top = -1;
    }

    public boolean push(int item) {
        if (top >= items.length - 1) {
            return false;
        }
        items[++top] = item;

        return true;
    }

    public int pop() {
        if (top >= 0) {
            return items[top--];
        } else
            return Integer.MIN_VALUE;
    }

    public int peek() {
        if (top >= 0) {
            return items[top];
        } else
            return Integer.MIN_VALUE;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == items.length - 1;
    }

    public static void  main(String[] args){
        CustStack stack = new CustStack(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.isFull());
    }
}
