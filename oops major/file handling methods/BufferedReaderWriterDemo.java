import java.io.*;

public class BufferedReaderWriterDemo
{
    public static void main(String[] args)
        throws IOException
    {
        BufferedWriter bw =
            new BufferedWriter(
                new FileWriter("sample.txt"));

        bw.write("Buffered Writer");

        bw.newLine();

        bw.write("Java IO");

        bw.close();

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