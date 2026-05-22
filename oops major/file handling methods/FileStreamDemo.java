import java.io.*;

public class FileStreamDemo
{
    public static void main(String[] args)
        throws IOException
    {
        FileOutputStream fout =
            new FileOutputStream("sample.txt");

        String s = "Hello Java";

        fout.write(s.getBytes());

        fout.close();

        FileInputStream fin =
            new FileInputStream("sample.txt");

        int x;

        while((x = fin.read()) != -1)
        {
            System.out.print((char)x);
        }

        fin.close();
    }
}