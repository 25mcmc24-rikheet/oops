import java.util.Iterator;
import java.util.NoSuchElementException;
class Node
{	
    int data;	
    Node next;	
    Node(int data)
    {	
	this.data = data;		
	this.next = null;
    }
}

class LinkedList implements Iterable<Integer>
{
    Node head;
    int size;

    public LinkedList()
    {
	this.head = null;
	this.size = 0;
    }
    public void insertAtHead(int d)
    {
	Node n = new Node(d);
	n.next = this.head;
	this.head = n;
	this.size++;
    }

    public int deleteFromHead()
    {
	int d = head.data;
	this.head = this.head.next;
	this.size--;
	return d;
    }
    public boolean isEmpty()
    {
	if(this.size == 0) return true;
	return false;
    }

    @Override public Iterator<Integer> iterator() 
    {
	return new LinkedListIterator(this.head);
    }

    public String toString()
    {
	String s = "";
	Node temp = this.head;
	while(temp != null)
	{
	    s = s + temp.data + "->"; 
	    temp = temp.next;
	}
	s = s + "X";
	return s;
    }
}

class LinkedListIterator implements Iterator<Integer> 
{
    private Node current;    
    public LinkedListIterator(Node head) 
    {
        this.current = head;
    }

    @Override public boolean hasNext() 
    {
        return current != null;
    }

    @Override public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int data = current.data;
        current = current.next;
        return data;
    }
}


public class LinkedListTest
{
    public static void main(String [] args)
    {
	LinkedList l = new LinkedList();
	l.insertAtHead(20);
	l.insertAtHead(30);
	l.insertAtHead(40);
	l.insertAtHead(50);
	Iterator<Integer> it = l.iterator();
	while (it.hasNext())
	{
		Integer s = it.next();
		System.out.println(s);
	}
    }
}
