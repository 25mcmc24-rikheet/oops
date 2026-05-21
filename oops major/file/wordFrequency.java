import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class wordFrequency
{
    public static void main(String[] args)
    {
        if(args.length == 0)
        {
            System.out.println("File name not provided");
            return;
        }

        String words[] = new String[100];
        int freq[] = new int[100];

        int count = 0;

        try
        {
            File f = new File(args[0]);

            Scanner sc = new Scanner(f);

            while(sc.hasNext())
            {
                String word = sc.next().toLowerCase();

                word = word.replaceAll("[^a-z]", "");

                if(word.length() == 0)
                    continue;

                int index = -1;

                for(int i = 0; i < count; i++)
                {
                    if(words[i].equals(word))
                    {
                        index = i;
                        break;
                    }
                }

                if(index == -1)
                {
                    words[count] = word;
                    freq[count] = 1;
                    count++;
                }
                else
                {
                    freq[index]++;
                }
            }

            sc.close();

            System.out.println("Word\tFrequency");

            for(int i = 0; i < count; i++)
            {
                System.out.println(words[i] + "\t" + freq[i]);
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found");
        }
    }
}