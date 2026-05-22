import java.io.*;
import java.util.*;

public class ScannerFormatterDemo
{
    public static void main(String[] args)
        throws IOException
    {
        Formatter f =
            new Formatter("sample.txt");

        f.format("%s %d %.2f",
                 "Rohit",
                 101,
                 95.5);

        f.close();

        Scanner sc =
            new Scanner(new File("sample.txt"));

        while(sc.hasNext())
        {
            System.out.println(sc.next());
        }

        sc.close();
    }
}