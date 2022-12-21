import Lists.LinkList;
import Lists.TwoWaysOfLinkList;


public class Main {
    public static void main(String[] args) {
        TwoWaysOfLinkList list = new TwoWaysOfLinkList();
        list.insertFirst(5);
        list.insertFirst(4);
        list.insertFirst(3);
        list.displayList();
        System.out.println("--------------");
        list.insertAfter(3, 2);
        list.displayList();
    }

}