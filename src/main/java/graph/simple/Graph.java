package graph.simple;

import linear.stack.CustStack;

/**
 * Created by Administrator on 2017/7/31.
 */
public class Graph {
    //定点数组
    private Vertex[] vertexList;

    //邻接矩阵
    private int[][] adjMat;

    //顶点的最大数目
    private int maxSize = 100;

    //当前顶点
    private int nVertex;

    //栈
    private CustStack stack;

    public Graph() {
        vertexList = new Vertex[maxSize];
        adjMat = new int[maxSize][maxSize];
        for (int i = 0; i < maxSize; i++) {
            for (int j = 0; j < maxSize; j++) {
                adjMat[i][j] = 0;
            }
        }
        nVertex = 0;
        stack = new CustStack();
    }


    /**
     * 添加顶点
     *
     * @param label
     */
    public void addVertex(char label) {
        vertexList[nVertex++] = new Vertex(label);
    }

    /**
     * 添加边
     *
     * @param start
     * @param end
     */
    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }


    public int getadjUnvisitedVertex(int v) {

        for (int i = 0; i < nVertex; i++) {
            if (adjMat[v][i] == 1 && vertexList[i].wasVisited == false) {
                return i;
            }
        }
        return -1;
    }

    public void dfs() {
        //首先访问0号顶点
        vertexList[0].wasVisited = true;

        //显示该顶点
        displayVertex(0);

        //压入栈中
        stack.push(0);

        while (!stack.isEmpty()) {
            //获得一个未访问的邻节点
            int v = getadjUnvisitedVertex(stack.peek());
            if (v == -1) {
                //弹出一个顶点
                stack.pop();
            } else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                stack.push(v);
            }
        }


        //搜索完成后，要讲访问信息修改
        for (int i = 0; i < nVertex; i++) {
            vertexList[i].wasVisited = false;
        }

    }

    public void mst() {
        //首先访问0号顶点
        vertexList[0].wasVisited = true;

        //显示该顶点
        //displayVertex(0);

        //压入栈中
        stack.push(0);

        while (!stack.isEmpty()) {
            //当前顶点
            int currentVertex = stack.peek();
            //获得一个未访问的邻节点
            int v = getadjUnvisitedVertex(currentVertex);
            if (v == -1) {
                //弹出一个顶点
                stack.pop();
            } else {
                vertexList[v].wasVisited = true;
                stack.push(v);
                displayVertex(currentVertex);
                System.out.print("-");
                displayVertex(v);
                System.out.print(" ");
            }
        }


        //搜索完成后，要讲访问信息修改
        for (int i = 0; i < nVertex; i++) {
            vertexList[i].wasVisited = false;
        }

    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex('a');
        graph.addVertex('b');
        graph.addVertex('c');
        graph.addVertex('d');
        graph.addVertex('e');
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);
        //graph.dfs();
        graph.mst();
    }


}
