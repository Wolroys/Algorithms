package Trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Data{
    public int val;

    public Data(int val){
        this.val = val;
    }

    public void displayData(){
        System.out.print("\\" + val);
    }
}

class Node{
    private static final int ORDER = 4;
    private int numItems;
    private Node parent;
    private final Node[] childArray = new Node[ORDER];
    private final Data[] itemArray = new Data[ORDER - 1];

    public void connectionChild(int childNum, Node child){
        childArray[childNum] = child;
        if (child != null)
            child.parent = this;
    }

    public Node disconnectChild(int childNum){
        Node temp = childArray[childNum];
        childArray[childNum] = null;
        return temp;
    }

    public Node getChild(int childNum){
        return childArray[childNum];
    }

    public Node getParent(){
        return parent;
    }

    public boolean isLeaf(){
        return childArray[0] == null;
    }

    public int getNumItems(){
        return numItems;
    }

    public Data getItem(int ind){
        return itemArray[ind];
    }

    public boolean isFull(){
        return numItems == ORDER - 1;
    }

    public int findItem(int key){
        for (int i = 0; i < ORDER - 1; i++){
            if (itemArray[i] == null)
                break;
            else if (itemArray[i].val == key){
                return i;
            }
        }
        return -1;
    }

    public int insertItem(Data newData){
        numItems++;
        int val = newData.val;
        for (int i = ORDER - 2; i >= 0; i--){
            if (itemArray[i] == null)
                continue;
            else{
                if (itemArray[i].val > val)
                    itemArray[i + 1] = itemArray[i];
                else{
                    itemArray[i + 1] = newData;
                    return i + 1;
                }
            }
        }
        itemArray[0] = newData;
        return 0;
    }

    public Data removeItem(){
        Data temp = itemArray[numItems - 1];
        itemArray[numItems - 1] = null;
        numItems--;
        return temp;
    }

    public void displayNode(){
        for (int i = 0; i < numItems; i++)
            itemArray[i].displayData();
        System.out.println("\\");
    }
}

class Tree234App{
    private Node root = new Node();


    public int find(int key){
        Node curNode = root;
        int num;

        while(true){
            if ((num = curNode.findItem(key)) != -1)
                return num;
            else if (curNode.isLeaf())
                return -1;
            else
                curNode = getNextChild(curNode, key);
        }
    }

    public void insert(int val){
        Node curNode = root;
        Data data = new Data(val);

        while(true){
            if (curNode.isFull()){
                split(curNode);
                curNode = curNode.getParent();

                curNode = getNextChild(curNode, val);
            }
            else if (curNode.isLeaf())
                break;
            else
                curNode = getNextChild(curNode, val);
        }

        curNode.insertItem(data);
    }

    public void split(Node curNode){
        Data B, C;
        Node parent, child2, child3;
        int itemIndex;

        C = curNode.removeItem();
        B = curNode.removeItem();
        child3 = curNode.disconnectChild(3);
        child2 = curNode.disconnectChild(2);
        Node newNode = new Node();

        if (curNode == root){
            root = new Node();
            parent = root;
            root.connectionChild(0, curNode);
        }
        else
            parent = curNode.getParent();

        itemIndex = parent.insertItem(B);
        int n = parent.getNumItems();

        for (int i = n - 1; i > itemIndex; i--){
            Node temp = parent.disconnectChild(i);
            parent.connectionChild(i + 1, temp);
        }

        parent.connectionChild(itemIndex + 1, newNode);

        newNode.insertItem(C);
        newNode.connectionChild(0, child2);
        newNode.connectionChild(1, child3);
    }

    private Node getNextChild(Node node, int value){
        int j;
        int numItems = node.getNumItems();

        for (j = 0; j < numItems; j++){
            if (value < node.getItem(j).val)
                return node.getChild(j);
        }
        return node.getChild(j);
    }
    public void display(){
        recDisplayTree(root, 0, 0);
    }

    private void recDisplayTree(Node root, int level, int childNumber){
        System.out.println("level=" + level + " child=" + childNumber + " ");
        root.displayNode();

        int numItems = root.getNumItems();
        for (int i = 0; i <= numItems; i++){
            Node next = root.getChild(i);
            if (next != null)
                recDisplayTree(next, level+1, i);
            else
                return;
        }
    }

}

public class Tree234 {
    public static void main(String[] args) throws IOException {
        Tree234App tree = new Tree234App();
        int val;

        tree.insert(50);
        tree.insert(40);
        tree.insert(60);
        tree.insert(30);
        tree.insert(70);
        tree.display();

    }
}
