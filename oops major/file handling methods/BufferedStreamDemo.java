import java.io.*;

public class BufferedStreamDemo
{
    public static void main(String[] args)
        throws IOException
    {
        BufferedOutputStream bout =
            new BufferedOutputStream(
                new FileOutputStream("sample.txt"));

        String s = "Buffered Stream Example";

        bout.write(s.getBytes());

        bout.close();

        BufferedInputStream bin =
            new BufferedInputStream(
                new FileInputStream("sample.txt"));

        int x;

        while((x = bin.read()) != -1)
        {
            System.out.print((char)x);
        }

        bin.close();
    }
}