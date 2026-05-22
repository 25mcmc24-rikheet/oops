import java.io.*;

public class PrintWriterDemo
{
    public static void main(String[] args)
        throws IOException
    {
        PrintWriter pw =
            new PrintWriter("sample.txt");

        pw.println("Hello");

        pw.println("Java");

        pw.printf("%d %.2f",
                  100,
                  99.45);

        pw.close();

        BufferedReader br =
            new BufferedReader(
                new FileReader("sample.txt"));

        String s;

        while((s = br.readLine()) != null)
        {
            System.out.println(s);
        }

        br.close();
    }
}