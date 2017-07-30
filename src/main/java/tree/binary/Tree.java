package tree.binary;

/**
 * Created by Administrator on 2017/7/29.
 */
public class Tree<E  extends   Comparable> {
    //Root Node
    private Node root;

    public void insert(E value){
        //封装节点
        Node newNode = new Node(value);

        //引用当前节点
        Node current = root;

        //引用父节点
        Node parent;

        if (null == root){
            root = newNode;
            return;
        }else{
            while (true){
                parent = current;
                if(current.data.compareTo(value) > 0){
                    current = current.left;
                    if ( current == null){
                        parent.left = newNode;
                        return;
                    }
                }else{
                    current = current.right;
                    if ( null == current){
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public Node element(E data){
        Node current = root;

        while (current.data.compareTo(data) != 0){
            if (current.data.compareTo(data) > 0){
                current = current.left;
            }else{
                current = current.right;
            }
            if ( null == current){
                return null;
            }
        }

        return current;
    }

    public void remove(E data){
        Node current = root;

        Node parent = root;


    }

    /**
     * 判空
     * @return
     */
    boolean isEmpty(){
        return true;
    }

    /**
     * 二叉树的结点个数
     * @return
     */
    int size(){
        return 0;
    }

    /**
     * 返回二叉树的高度或者深度,即结点的最大层次
     * @return
     */
    int height(){
        return 0;
    }

    /**
     * 先根次序遍历
     */
    public void  preOrder(Node root){
        if (null != root){
            //访问根节点
            System.out.println(root.data);

            //前序遍历左子树
            preOrder(root.left);
            //前序遍历右子树
            preOrder(root.right);
        }
    }

    /**
     * 中根次序遍历
     */
    public void inOrder(){

    }

    /**
     * 后根次序遍历
     */
    public void postOrder(){

    }

    /**
     * 层次遍历
     */
    public void levelOrder(){

    }

}
