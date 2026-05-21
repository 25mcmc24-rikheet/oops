import java.io.*;
import java.util.*;

public class RandomArrayFile
{
    static void writeArray(int arr[],String fileName)
        throws IOException
    {
        RandomAccessFile rf =
            new RandomAccessFile(fileName,"rw");

        rf.writeInt(arr.length);

        for(int i=0;i<arr.length;i++)
        {
            rf.writeInt(arr[i]);
        }

        rf.close();
    }

    static void updateElement(
        String fileName,
        int index,
        int value)
        throws IOException
    {
        RandomAccessFile rf =
            new RandomAccessFile(fileName,"rw");

        int n = rf.readInt();

        if(index < 0 || index >= n)
        {
            System.out.println("Invalid Index");

            rf.close();

            return;
        }

        rf.seek(4 + index * 4);

        rf.writeInt(value);

        rf.close();
    }

    static void displayFile(String fileName)
        throws IOException
    {
        RandomAccessFile rf =
            new RandomAccessFile(fileName,"r");

        int n = rf.readInt();

        System.out.println("Array Elements");

        for(int i=0;i<n;i++)
        {
            System.out.print(rf.readInt() + " ");
        }

        System.out.println();

        rf.close();
    }

    public static void main(String[] args)
        throws Exception
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int arr[] = new int[n];

        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }

        writeArray(arr,"array.dat");

        System.out.println("Original File");

        displayFile("array.dat");

        int index = sc.nextInt();

        int value = sc.nextInt();

        updateElement("array.dat",index,value);

        System.out.println("Updated File");

        displayFile("array.dat");

        sc.close();
    }
}