import java.util.Scanner;
import java.util.Arrays;
import java.io.FileInputStream;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
public class ByteNumbersSort
{
    public static void main(String args[])
    {
	if(args.length != 2)
	{
	    System.out.println("INVALID Arguments! Pass output file name:");
	    return;
	}
	try
	{
	    FileInputStream input = new FileInputStream(args[0]);
	    FileOutputStream output = new FileOutputStream(args[1]);
	    DataInputStream dosin = new DataInputStream(input);
	    DataOutputStream dosout = new DataOutputStream(output);
	    int n = dosin.readInt();
	    int [] arr = new int[n];
	    for(int i = 0; i < n; i++)
	    {
		arr[i] = dosin.readInt();
	    }
	    dosin.close();
	    input.close();
	    Arrays.sort(arr);
	    dosout.writeInt(n);

	    System.out.println("ARRAY ELEMENTS:");
	    for(int i = 0; i < n; i++)
	    {
		dosout.writeInt(arr[i]);
		System.out.print(arr[i] + " ");
	    }
	    dosout.close();
	    output.close();
	}
	catch(FileNotFoundException e)
	{
	    System.out.println("File Not Found Exception");
	}
	catch(IOException e)
	{
	    System.out.println("Error in reading the file");
	}
    }
}


