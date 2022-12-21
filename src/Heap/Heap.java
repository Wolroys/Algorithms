package Heap;

class N{
    private int val;

    public N(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "N{" +
                "val=" + val +
                '}';
    }
}


public class Heap {
    private N[] heapArray;
    private int maxSize;
    private int currentSize;


    public Heap(N[] heapArray, int maxSize, int currentSize) {
        this.heapArray = heapArray;
        this.maxSize = maxSize;
        this.currentSize = currentSize;
    }

    public boolean insert(int val){
        if (currentSize == maxSize)
            return false;
        N newNode = new N(val);
        heapArray[currentSize] = newNode;
        trickleUp(currentSize++);
        return true;
    }

    public void trickleUp(int ind){
        int parent = (ind - 1) / 2;
        N bottom = heapArray[ind];

        while (ind > 0 && bottom.getVal() > heapArray[parent].getVal()){
            heapArray[ind] = heapArray[parent];
            ind = parent;
            parent = (parent - 1) / 2;
        }
        heapArray[ind] = bottom;
    }

    public N remove(){
        N temp = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return temp;
    }

    public void trickleDown(int ind){
        int largeChild;
        N top = heapArray[0];
        while (ind < currentSize / 2){
            int leftChild = 2*ind + 1;
            int rightChild = leftChild+1;
            if (rightChild < currentSize && heapArray[leftChild].getVal() <
            heapArray[rightChild].getVal())
                largeChild = rightChild;
            else
                largeChild = leftChild;

            if (top.getVal() >= heapArray[largeChild].getVal())
                break;

            heapArray[ind] = heapArray[largeChild];
            ind = largeChild;
        }

        heapArray[ind] = top;
    }

    public boolean change(int ind, int newVal){
        if (ind < 0 && ind >= currentSize)
            return false;

        int temp = heapArray[ind].getVal();
        heapArray[ind].setVal(newVal);
        if (temp < newVal)
            trickleUp(ind);
        else
            trickleDown(ind);

        return true;
    }
}

class HeapApp{
    public static void main(String[] args) {

    }
}
