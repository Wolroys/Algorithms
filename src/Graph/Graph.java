package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Vertex{
    public char label;
    public boolean isVisited;

    public Vertex(char label){
        this.label = label;
        isVisited = false;
    }
}

public class Graph {

    private final int MAX_VERTS = 20;
    private Vertex[] vertexList;
    private int[][] adjMat;
    private int nVerts;
    private Stack<Integer> stack;
    private Queue<Integer> queue;


    public Graph(){
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int i=0; i < MAX_VERTS; i++){
            for (int j = 0; j < MAX_VERTS; j++){
                adjMat[i][j] = 0;
            }
        }
        stack = new Stack<>();
        queue = new LinkedList<>();
    }

    public void addVertex(char v){
        vertexList[nVerts++] = new Vertex(v);
    }

    public void addEdge(int start, int end){
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int v){
        System.out.println(vertexList[v].label);
    }

    public void dfs(){
        vertexList[0].isVisited = true;
        displayVertex(0);
        stack.push(0);

        while (!stack.isEmpty()){

            int res = getAdjUnvisitedVertex(stack.peek());

            if (res == -1)
                stack.pop();
            else{
                vertexList[res].isVisited = true;
                displayVertex(res);
                stack.push(res);
            }
        }

        for (int i = 0; i < nVerts; i++){
            vertexList[i].isVisited = false;
        }
    }

    public void bfs(){
        vertexList[0].isVisited = true;
        displayVertex(0);
        queue.offer(0);
        int v;

        while (!queue.isEmpty()){
            int v1 = queue.poll();

            while ((v = getAdjUnvisitedVertex(v1)) != -1){
                vertexList[v].isVisited = true;
                displayVertex(v);
                queue.offer(v);
            }
        }

        for (int i = 0; i < nVerts; i++){
            vertexList[i].isVisited = false;
        }
    }

    public int getAdjUnvisitedVertex(int v){
        for (int i = 0; i < nVerts; i++){
            if (adjMat[v][i] == 1 && !vertexList[i].isVisited){
                return i;
            }
        }
        return -1;
    }
}

class Main{
    public static void main(String[] args)
    {
        Graph theGraph = new Graph();
        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');
        theGraph.addEdge(0, 1);
        theGraph.addEdge(1, 2);
        theGraph.addEdge(0, 3);
        theGraph.addEdge(3, 4);
        System.out.print("Visits: ");
        theGraph.bfs();
        System.out.println();
    }
}
