package tree.binary;

/**
 * Created by Administrator on 2017/7/29.
 */
public class Tree<E extends Comparable> {
    //Root Node
    private Node root;

    public void insert(E value) {
        //封装节点
        Node newNode = new Node(value);

        //引用当前节点
        Node current = root;

        //引用父节点
        Node parent;

        if (null == root) {
            root = newNode;
            return;
        } else {
            while (true) {
                parent = current;
                if (current.data.compareTo(value) > 0) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (null == current) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public Node element(E data) {
        Node current = root;

        while (current.data.compareTo(data) != 0) {
            if (current.data.compareTo(data) > 0) {
                current = current.left;
            } else {
                current = current.right;
            }
            if (null == current) {
                return null;
            }
        }

        return current;
    }

    public boolean remove(E data) {
        //封装节点
        Node newNode = new Node(data);

        //引用当前节点
        Node current = root;

        //引用父节点
        Node parent = root;

        boolean isLeftChild = true;

        while ((current.data.compareTo(data) != 0)) {
            parent = current;
            if (current.data.compareTo(data) > 0) {
                current = current.left;
                isLeftChild = true;
            } else {
                current = current.right;
                isLeftChild = false;
            }

            if (null == current) {
                return false;
            }
        }

        //删除叶子节点
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            }
            if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        }else{
            Node successor = getSuccessor(current);
            if (current == root){
                root = successor;
            }else if (isLeftChild){
                parent.left = successor;
            }else{
                parent.right = successor;
            }
            successor.left = current.left;
        }

        return true;
    }

    public Node getSuccessor(Node delNode){
        Node successor = delNode;

        Node successorParent = delNode;

        Node current = delNode.right;

        while(null != current){
            successorParent = successor;
            successor = current;
            System.out.println(successorParent==successor);
            current = current.left;
        }
        if (successor != delNode.right){
            //?????
            successorParent.left = successor.right;
            successor.right = delNode.right;
        }
        return successor;
    }

    /**
     * 判空
     *
     * @return
     */
    boolean isEmpty() {
        return true;
    }

    /**
     * 二叉树的结点个数
     *
     * @return
     */
    int size() {
        return 0;
    }

    /**
     * 返回二叉树的高度或者深度,即结点的最大层次
     *
     * @return
     */
    int height() {
        return 0;
    }

    /**
     * 先根次序遍历
     */
    public void preOrder(Node local) {
        if (null != local) {
            //访问根节点
            System.out.println(local.data);

            //前序遍历左子树
            preOrder(local.left);
            //前序遍历右子树
            preOrder(local.right);
        }
    }

    /**
     * 中根次序遍历
     */
    public void inOrder(Node local) {
        if (null != local) {
            //中序遍历左子树
            preOrder(local.left);

            //访问根节点
            System.out.println(local.data);


            //中序遍历右子树
            preOrder(local.right);
        }
    }

    /**
     * 后根次序遍历
     */
    public void postOrder(Node local) {
        if (null != local) {
            //后序遍历左子树
            preOrder(local.left);
            
            //访问根节点
            System.out.println(local.data);

            //后序遍历右子树
            preOrder(local.right);
        }
    }

    /**
     * 层次遍历
     */
    public void levelOrder() {

    }

    public static void main(String[] args){
        Tree tree = new Tree<Integer>();

        tree.insert(new Integer(10));
        tree.insert(new Integer(20));
        tree.insert(new Integer(15));
        tree.insert(new Integer(3));
        tree.insert(new Integer(4));
        tree.insert(new Integer(90));
/*        System.out.println(tree.root.data);
        System.out.println(tree.root.right.data);
        System.out.println(tree.root.right.left.data);
        System.out.println(tree.root.left.data);
        System.out.println(tree.element(new Integer(3)).data);*/
        Node node = new Node(new Integer(20));
        tree.preOrder(node);
    }

}
