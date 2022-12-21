package Lists;


class Link{
    public int value;
    public Link next;
    public Link previous;

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

public class TwoWaysOfLinkList {
    private Link first;
    private Link last;

    public TwoWaysOfLinkList(){
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void insertFirst(int val){

        Link newLink = new Link(val);

        if (isEmpty())
            last = newLink;
        else
            first.previous = newLink;

        newLink.next = first;
        first = newLink;
    }

    public void insetLast(int val){
        Link newLink = new Link(val);

        if (isEmpty()){
            first = newLink;
        }
        else
            last.next = newLink;

        newLink.previous = last;
        last = newLink;
    }

    public void insertAfter(int val, int newVal){
        Link newLink = new Link(newVal);
        Link curr = first;

        while (curr.value != val){
            if (curr == null)
                return;
            else
                curr = curr.next;
        }

        if (curr == last){
            newLink.next = null;
            last = newLink;
        }
        else{
            newLink.next = curr.next;
            curr.next.previous = newLink;
        }

        newLink.previous = curr;
        curr.next = newLink;
    }

    public void displayList(){
        Link curr = first;
        while (curr != null){
            System.out.println(curr);
            curr = curr.next;
        }
    }

    public void deleteFirst(){
        if (first.next == null)
            first = null;
        else
            first.next.previous = null;

        assert first != null;
        first = first.next;
    }

    public void deleteLast(){
        if (first.next == null)
            first = null;
        else
            last.previous.next = null;

        assert last != null;
        last = last.previous;
    }

    public void deleteKey(int val){
        Link curr = first;

        while (curr.value != val){
            curr = curr.next;

            if (curr == null)
                return;
        }

        if (curr == first)
            first = curr.next;
        else
            curr.previous.next = curr.next;

        if (curr == last)
            last = curr.previous;
        else
            curr.next.previous = curr.previous;

    }
}
