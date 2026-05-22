interface MyIterator<T>
{
    boolean hasNext();

    T next();
}

class Node<T>
{
    T data;

    Node<T> next;

    Node(T data)
    {
        this.data = data;

        this.next = null;
    }
}

class LinkedList<T>
{
    Node<T> head;

    LinkedList()
    {
        head = null;
    }

    void insert(T data)
    {
        Node<T> temp = new Node<>(data);

        if(head == null)
        {
            head = temp;
        }
        else
        {
            Node<T> cur = head;

            while(cur.next != null)
            {
                cur = cur.next;
            }

            cur.next = temp;
        }
    }

    void display()
    {
        Node<T> cur = head;

        while(cur != null)
        {
            System.out.print(cur.data + " ");

            cur = cur.next;
        }

        System.out.println();
    }

    MyIterator<T> iterator()
    {
        return new LinkedListIterator();
    }

    class LinkedListIterator
        implements MyIterator<T>
    {
        Node<T> current;

        LinkedListIterator()
        {
            current = head;
        }

        public boolean hasNext()
        {
            return current != null;
        }

        public T next()
        {
            T x = current.data;

            current = current.next;

            return x;
        }
    }
}

public class ownIterator
{
    public static void main(String[] args)
    {
        LinkedList<Integer> list =
            new LinkedList<>();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);

        System.out.println("Linked List");

        list.display();

        System.out.println();

        System.out.println(
            "Using Custom Iterator");

        MyIterator<Integer> it =
            list.iterator();

        while(it.hasNext())
        {
            System.out.println(it.next());
        }
    }
}