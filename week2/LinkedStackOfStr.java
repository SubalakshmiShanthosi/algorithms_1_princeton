public class LinkedStackOfStr {
    
    private Node first=null;

    private class  Node {
    
        String item;
        Node next;
    }

    public boolean isEmpty()
    {
        return first == null;
    }

    public void push(String item)
    {   
        Node oldFirst = first;
        first = new Node();
        first.item=item;
        first.next=oldFirst;
    }

    public String pop()
    {
        if(first == null )
        {
            System.out.println("Stack underflow");
            return "";
        }
        String item = first.item;
        first = first.next;
        return item;
    }

    public void display()
    {   Node temp = first;
        if(isEmpty())
            return;
        while(temp!=null)
        {
            System.out.print(" "+temp.item+" -> ");
            temp = temp.next;
        }
    }
}
