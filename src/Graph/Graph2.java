package Graph;

import java.util.Queue;
import java.util.Stack;

public class Graph2 {
    private final int MAX_VERTS = 20;
    private Vertex[] vertexList;
    private int[][] adjMat;
    private int nVerts;
    private char[] sortedArray;

    public Graph2(){
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int i = 0; i < MAX_VERTS; i++){
            for (int j = 0; j < MAX_VERTS; j++){
                adjMat[i][j] = 0;
            }
        }

        sortedArray = new char[MAX_VERTS];
    }

    public void addVertex(char val){
        vertexList[nVerts++] = new Vertex(val);
    }

    public void addEdge(int start, int end){
        adjMat[start][end] = 1;
    }

    public void displayVertex(int ind){
        System.out.print(vertexList[ind].label);
    }

    public void topo(){
        int orgVerts = nVerts;

        while (nVerts > 0){
            int currentVertex = noSuccessor();

            if (currentVertex == -1){
                System.err.println("We have a problem here");
                return;
            }
            sortedArray[nVerts-1] = vertexList[currentVertex].label;

            deleteVertex(currentVertex);
        }

        System.out.println("Sorted array is ready:");
        for (int i = 0; i < orgVerts; i++){
            System.out.print(sortedArray[i]);
        }
        System.out.println("");
    }


    public int noSuccessor(){
        boolean isEdge;

        for (int i = 0; i < nVerts; i++){
            isEdge = false;
            for (int j = 0; j < nVerts; j++){
                if (adjMat[i][j] > 0){
                    isEdge = true;
                    break;
                }
            }
            if (!isEdge)
                return i;
        }
        return -1;
    }

    public void deleteVertex(int val){
        if (val != nVerts - 1){
            for (int j = val; j < nVerts - 1; j++){
                vertexList[j] = vertexList[j + 1];
            }

            for (int j = val; j < nVerts - 1; j++){
                moveRowUp(j, nVerts);
            }

            for (int col = val; col < nVerts - 1; col++){
                moveColLeft(col, nVerts);
            }
        }
        nVerts--;
    }

    public void moveColLeft(int col, int length) {
        for (int i = 0; i < length; i++) {
            adjMat[i][col] = adjMat[i][col + 1];
        }
    }

    public void moveRowUp(int row, int length){
        for (int i = 0; i < length; i++){
            adjMat[row][i] = adjMat[row+1][i];
        }
    }
}

class Bench{
    public static void main(String[] args) {
        Graph2 theGraph = new Graph2();
        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');
        theGraph.addVertex('F');
        theGraph.addVertex('G');
        theGraph.addVertex('H');
        theGraph.addEdge(0, 3);
        theGraph.addEdge(0, 4);
        theGraph.addEdge(1, 4);
        theGraph.addEdge(2, 5);
        theGraph.addEdge(3, 6);
        theGraph.addEdge(4, 6);
        theGraph.addEdge(5, 7);
        theGraph.addEdge(6, 7);
        theGraph.topo();
    }
}
