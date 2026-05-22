import java.io.*;

public class FileReaderWriterDemo
{
    public static void main(String[] args)
        throws IOException
    {
        FileWriter fw =
            new FileWriter("sample.txt");

        fw.write("File Writer Example");

        fw.close();

        FileReader fr =
            new FileReader("sample.txt");

        int x;

        while((x = fr.read()) != -1)
        {
            System.out.print((char)x);
        }

        fr.close();
    }
}