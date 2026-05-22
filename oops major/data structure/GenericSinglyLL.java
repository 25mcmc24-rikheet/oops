import java.util.*;

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

class GenericLinkedList<T extends Comparable<T>>
{
    Node<T> head;
    int size;

    GenericLinkedList()
    {
        head = null;
        size = 0;
    }

    void insertFirst(T data)
    {
        Node<T> temp = new Node<>(data);

        temp.next = head;

        head = temp;

        size++;
    }

    void insertLast(T data)
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

        size++;
    }

    void insertAtIndex(int index,T data)
    {
        if(index < 0 || index > size)
        {
            System.out.println("INVALID INPUT");
            System.exit(0);
        }

        if(index == 0)
        {
            insertFirst(data);
            return;
        }

        Node<T> temp = new Node<>(data);

        Node<T> cur = head;

        for(int i=0;i<index-1;i++)
        {
            cur = cur.next;
        }

        temp.next = cur.next;

        cur.next = temp;

        size++;
    }

    T removeFirst()
    {
        if(head == null)
        {
            System.out.println("LE");
            return null;
        }

        T x = head.data;

        head = head.next;

        size--;

        return x;
    }

    T removeLast()
    {
        if(head == null)
        {
            System.out.println("LE");
            return null;
        }

        if(head.next == null)
        {
            T x = head.data;

            head = null;

            size--;

            return x;
        }

        Node<T> cur = head;

        while(cur.next.next != null)
        {
            cur = cur.next;
        }

        T x = cur.next.data;

        cur.next = null;

        size--;

        return x;
    }

    T removeAtIndex(int index)
    {
        if(index < 0 || index >= size)
        {
            System.out.println("INVALID INPUT");
            System.exit(0);
        }

        if(head == null)
        {
            System.out.println("LE");
            return null;
        }

        if(index == 0)
        {
            return removeFirst();
        }

        Node<T> cur = head;

        for(int i=0;i<index-1;i++)
        {
            cur = cur.next;
        }

        T x = cur.next.data;

        cur.next = cur.next.next;

        size--;

        return x;
    }

    int numberOfElements()
    {
        return size;
    }

    T maximumElement()
    {
        if(head == null)
        {
            System.out.println("LE");
            return null;
        }

        T max = head.data;

        Node<T> cur = head.next;

        while(cur != null)
        {
            if(cur.data.compareTo(max) > 0)
            {
                max = cur.data;
            }

            cur = cur.next;
        }

        return max;
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
}

public class GenericSinglyLL
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        GenericLinkedList<Integer> list =
            new GenericLinkedList<>();

        while(true)
        {
            int ch = sc.nextInt();

            switch(ch)
            {
                case 1:
                {
                    int e = sc.nextInt();

                    list.insertFirst(e);

                    break;
                }

                case 2:
                {
                    int e = sc.nextInt();

                    list.insertLast(e);

                    break;
                }

                case 3:
                {
                    int i = sc.nextInt();

                    int e = sc.nextInt();

                    list.insertAtIndex(i,e);

                    break;
                }

                case 4:
                {
                    Integer x = list.removeFirst();

                    if(x != null)
                        System.out.println(x);

                    break;
                }

                case 5:
                {
                    Integer x = list.removeLast();

                    if(x != null)
                        System.out.println(x);

                    break;
                }

                case 6:
                {
                    int i = sc.nextInt();

                    Integer x = list.removeAtIndex(i);

                    if(x != null)
                        System.out.println(x);

                    break;
                }

                case 7:
                {
                    list.display();

                    break;
                }

                case 8:
                {
                    System.out.println(
                        list.numberOfElements());

                    break;
                }

                case 9:
                {
                    Integer x =
                        list.maximumElement();

                    if(x != null)
                        System.out.println(x);

                    break;
                }

                case -1:
                {
                    return;
                }

                default:
                {
                    System.out.println(
                        "INVALID INPUT");

                    return;
                }
            }
        }
    }
}