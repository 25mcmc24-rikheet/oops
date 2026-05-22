import java.util.*;

class Node<r>
{
    r data;
    Node <r> next;
    Node <r> prev;

    Node (r data)
    {
        this.data=data;
        this.next=null;
        this.prev=null;
    }
}

class LinkedList<r>
{
    Node <r> head;
    Node <r> tail;
    int size;

    public LinkedList()
    {
        this.head=null;
        this.tail=null;
        this.size=0;
    }

    public void insertFirst(r data)
    {
        Node<r> n=new Node<>(data);
        if(this.head==null)
        {
            this.head=n;
            this.tail=n;
        }
        else
        {
            n.next=this.head;
            this.head.prev=n;
            this.head=n;
        }
        this.size++;
    }

    public void insertLast(r data)
    {
        Node<r> n=new Node<>(data);
        if(this.head==null)
        {
            this.head=n;
            this.tail=n;
        }
        else
        {
            this.tail.next=n;
            n.prev=this.tail;
            this.tail=n;
        }
        this.size++;
    }

    public boolean insertAtIndex(int index , r data)
    {
        if(index<0 || index>this.size)
        {
            return false;
        }
        if(index==0)
        {
            insertFirst(data);
        }
        else if(index==this.size)
        {
            insertLast(data);
        }
        else
        {
            Node <r> temp=this.head;
            for(int i=0;i<index-1;i++)
            {
                temp=temp.next;
            }
            Node <r> n=new Node<>(data);
            n.next=temp.next;
            n.prev=temp;
            temp.next.prev=n;
            temp.next=n;
            this.size++;
        }
        return true;
    }

    public r removeFirst()
    {
        r data=this.head.data;
        if(this.head==this.tail)
        {
            this.head=null;
            this.tail=null;
        }
        else
        {
            this.head=this.head.next;
            this.head.prev=null;
        }
        this.size--;
        return data;
    }

    public r removeLast()
    {
        if(this.head==null)
            return null;
        r val=this.tail.data;

        if(this.head==this.tail)
        {
            this.head=null;
            this.tail=null;
        }
        else
        {
            this.tail=this.tail.prev;
            this.tail.next=null;
        }
        this.size--;
        return val;
    }

    public r removeAtIndex(int index)
    {
        if(index<0 || index>=this.size)
            return null;
        if(index==0)
        {
            return removeFirst();
        }

        else if(index==this.size-1)
        {
            return removeLast();
        }
        else
        {
            Node<r> temp=this.head;
            for(int i=0;i<index;i++)
            {
                temp=temp.next;
            }

            r val=temp.data;
            temp.prev.next=temp.next;
            temp.next.prev=temp.prev;
            this.size--;
            return val;
        }
    }

    public boolean isEmpty()
    {
        if(this.size==0)
            return true;
        return false;
    }

    public String toString()
    {
        String s="";
        Node<r> temp=this.head;
        while(temp!=null)
        {
            s=s+temp.data+"->";
            temp=temp.next;
        }
        s=s+"X";
        return s;
    }
}

public class generic_doubly_linkedlist 
{
public static void main(String [] args)
{
    Scanner sc = new Scanner(System.in);
    LinkedList<Integer> dll = new LinkedList<>();

    while(true)
    {
        if(!sc.hasNextInt())
        {
            System.out.println("INVALID INPUT");
            return;
        }

        int choice = sc.nextInt();

        if(choice == -1)
            return;

        switch(choice)
        {
            case 1:
                if(!sc.hasNextInt())
                {
                    System.out.println("INVALID INPUT");
                    return;
                }
                dll.insertFirst(sc.nextInt());
                break;

            case 2:
                if(!sc.hasNextInt())
                {
                    System.out.println("INVALID INPUT");
                    return;
                }
                dll.insertLast(sc.nextInt());
                break;

            case 3:
                if(!sc.hasNextInt())
                {
                    System.out.println("INVALID INPUT");
                    return;
                }
                int index = sc.nextInt();

                if(!sc.hasNextInt())
                {
                    System.out.println("INVALID INPUT");
                    return;
                }
                int val = sc.nextInt();

                if(index < 0 || index > dll.size)
                {
                    System.out.println("INVALID INPUT");
                    return;
                }

                dll.insertAtIndex(index, val);
                break;

            case 4:
                if(dll.isEmpty())
                {
                    System.out.print("LE ");
                }
                else
                {
                    System.out.print(dll.removeFirst() + " ");
                }
                break;

            case 5:
                if(dll.isEmpty())
                {
                    System.out.print("LE ");
                }
                else
                {
                    System.out.print(dll.removeLast() + " ");
                }
                break;

            case 6:
                if(!sc.hasNextInt())
                {
                    System.out.println("INVALID INPUT");
                    return;
                }

                int Index2 = sc.nextInt();

                if(dll.isEmpty())
                {
                    System.out.print("LE ");
                    break;
                }

                if(Index2 < 0 || Index2 >= dll.size)
                {
                    System.out.println("INVALID INPUT");
                    return;
                }

                System.out.print(dll.removeAtIndex(Index2) + " ");
                break;

            case 7:
                Node<Integer> temp = dll.head;
                while(temp != null)
                {
                    System.out.print(temp.data + " ");
                    temp = temp.next;
                }
                break;

            default:
                System.out.println("INVALID INPUT");
                return;
        }
    }
}
}
