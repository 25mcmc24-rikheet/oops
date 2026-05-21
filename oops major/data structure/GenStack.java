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

class GenericStack<T>
{
    Node<T> top;

    GenericStack()
    {
        top = null;
    }

    void push(T data)
    {
        Node<T> temp = new Node<>(data);

        temp.next = top;

        top = temp;
    }

    T pop()
    {
        if(top == null)
        {
            System.out.println("Stack Underflow");
            return null;
        }

        T x = top.data;

        top = top.next;

        return x;
    }

    void display()
    {
        Node<T> temp = top;

        while(temp != null)
        {
            System.out.println(temp.data);

            temp = temp.next;
        }
    }
}

public class GenStack
{
    public static void main(String[] args)
    {
        GenericStack<Integer> s = new GenericStack<>();

        s.push(10);
        s.push(20);
        s.push(30);

        s.display();

        System.out.println("Popped : " + s.pop());

        System.out.println("After Pop");

        s.display();
    }
}