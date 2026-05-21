//sequential file processing
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Formatter;
import java.util.Arrays;
public class SortingMarksFile
{
    public static void main(String args[])
    {
	//processing command line arguements
	if(args.length != 2)
	{
	    System.out.println("Mismatch in Number of arguements. Program exiting");
	    return;
	}
	String inFileName = args[0];
	String outFileName = args[1];

	//Creating File Objects
	File inFile = new File(inFileName);
	File outFile = new File(outFileName);
	try 
	{
	    //Creating Scanner and Formatter objects
	    Scanner sc = new Scanner(inFile);
	    Formatter output = new Formatter(outFile);
	    int n = sc.nextInt();
	    int [] arr = new int[n];
	    for(int i = 0; i < n; i++)
	    {
		arr[i] = sc.nextInt();
	    }
	    Arrays.sort(arr);
	    output.format("%d ", n);
	    for(int i = 0; i < n; i++)
	    {
		output.format("%d ", arr[i]);
	    }
	    sc.close();
	    output.close();
	} 
	catch (FileNotFoundException e) 
	{
	    System.out.println("Error in opening the input file:");
	    e.printStackTrace();
	}

    }
}
