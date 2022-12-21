package Trees;

/*public class BinaryTree {
    private Node root;

    public BinaryTree(){
        root = null;
    }
    public Node find(int val){
        Node current = root;

        while (current.val != val){

            if (current.val >= val)
                current = current.rightChild;
            else
                current = current.leftChild;

            if (current == null)
                return null;
        }
        return current;
    }

    public void insert(int val){
        Node newNode = new Node();
        newNode.val = val;

        Node current = root;

        if (current == null)
            root = newNode;

        else{
            Node parent;
            while (true){
                parent = current;
                if (val < current.val){
                    current = current.leftChild;

                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                }
                else {
                    current = current.rightChild;

                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public boolean remove(int val){
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;
        while (current.val != val){
            parent = current;
            if (val < current.val){
                isLeftChild = true;
                current = current.leftChild;
            }
            else{
                isLeftChild = false;
                current = current.rightChild;
            }

            if (current == null)
                return false;
        }

        if (current.leftChild == null && current.rightChild == null){
            if (current == root)
                root = null;

            else if (isLeftChild)
                parent.leftChild = null;
            else
                parent.rightChild = null;
        }

        else if (current.rightChild == null){
            if (current == root)
                root = current.leftChild;

            else if(isLeftChild){
                parent.leftChild = current.leftChild;
            }
            else
                parent.rightChild = current.leftChild;
        }

        else if (current.leftChild == null){
            if (current == root)
                root = current.rightChild;

            else if (isLeftChild)
                parent.rightChild = current.rightChild;

            else
                parent.leftChild = current.rightChild;
        }


        else{
            Node successor = getSuccessor(current);

            if (current == root)
                root = successor;

            else if (isLeftChild)
                parent.leftChild = successor;

            else
                parent.rightChild = successor;

            successor.leftChild = current.leftChild;
        }
        return true;
    }

    private Node getSuccessor(Node delNode){
        Node parentSuccessor = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;
        while (current != null){
            parentSuccessor = successor;
            successor = current;
            current = current.leftChild;
        }

        if (successor != delNode.rightChild){
            parentSuccessor.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }


        return successor;
    }

    public void inOrder(Node root){
        if (root != null){
            inOrder(root.leftChild);
            System.out.print(root.val + " ");
            inOrder(root.rightChild);
        }
    }

    public Node min(){
        Node current = root;
        Node last = root;

        while (current != null){
            last = current;
            current = current.leftChild;
        }

        return last;
    }

    public Node max(){
        Node current = root;
        Node last = root;

        while (current != null){
            last = current;
            current = current.rightChild;
        }

        return last;
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                '}';
    }


}*/
