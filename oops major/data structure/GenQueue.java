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

class GenericQueue<T>
{
    Node<T> front;
    Node<T> rear;

    GenericQueue()
    {
        front = null;
        rear = null;
    }

    void enqueue(T data)
    {
        Node<T> temp = new Node<>(data);

        if(rear == null)
        {
            front = temp;
            rear = temp;
        }
        else
        {
            rear.next = temp;
            rear = temp;
        }
    }

    T dequeue()
    {
        if(front == null)
        {
            System.out.println("Queue Underflow");
            return null;
        }

        T x = front.data;

        front = front.next;

        if(front == null)
        {
            rear = null;
        }

        return x;
    }

    void display()
    {
        Node<T> temp = front;

        while(temp != null)
        {
            System.out.println(temp.data);

            temp = temp.next;
        }
    }
}

public class GenQueue
{
    public static void main(String[] args)
    {
        GenericQueue<Integer> q = new GenericQueue<>();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        q.display();

        System.out.println("Dequeued : " + q.dequeue());

        System.out.println("After Dequeue");

        q.display();
    }
}