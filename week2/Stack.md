# Week 2  - Stack Data structure

All collections like stack/ queue/ bag datastructure the idea behind operating with these collection of objects are same
    1. We want to add some element to the collection.
    2. We want to determine the size of the collection.
    3. We want to iterate through the data items in the collection.
    4. Test if the collection is empty?
    5. We want to perform some operation on that collection.

The intent is very clear - the Key is **when it comes to removing the items, which Item do we remove?**
The two fundamental classic data structures for this, the stack and the queue, differ in the way in which the item to be removed is chosen. For the stack, we take out the item that was most recently added.

Stack datastructure can also be represented using Array --
        
        Only downsite is that the size/ capacity of the stack needs to be known prior to allocate the array memory space
        Solution to this problem - Dynamic re-sizing the array

```java
public class StackUsingArray{

    private String[] item;
    private int N=0;
    
    public StackUsingArray()
    {
        item = new String[1];
    }

    public void push(String aInpItem)
    {
        if(N == item.length) 
            resize(2 * item.length);
        item[N++] = aInpItem;
    }

    private void resize(int capacity)
    {
        private String[] copy = new String[capacity];
        for(int i=0;i<item.length;i++)
            copy[i] = item[i];
        item = copy;
    }

    private String pop()
    {
        String itemStrAtTop = item[--N];
        item[N]=null;
        if(N>0 && N == item.length/4)
                resize(item.length/2);
        return itemStrAtTop;
    }
}
```