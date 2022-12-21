package Lists;

/*
class Link{
    public int value;
    public Link next;

    public Link(int value){
        this.value = value;
    }

    public Link(int value, Link next){
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return "val: " + value;
    }
}
*/

public class LinkList {
    private Link first;

    public LinkList(){
        first = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void insertFirst(int value){
        Link link = new Link(value);

        link.next = first;
        first = link;
    }

    public Link deleteFirst(){
        Link temp = first;
        first = first.next;
        return temp;
    }

    public void displayList(){
        Link curr = first;
        while (curr != null){
            System.out.println(curr);
            curr = curr.next;
        }
    }

    public Link find(int value){
        Link curr = first;

        while (curr.value != value){
            if (curr == null)
                return null;
            else
                curr = curr.next;
        }
        
        return curr;
    }

    public void delete(int value){
        Link curr = first;
        Link previous = first;

        while (curr.value != value){

            if (curr == null)
                return;
            else {
                previous = curr;
                curr = curr.next;
            }
        }

        if (curr == first)
            first = first.next;
        else
            previous.next = curr.next;

    }



}
