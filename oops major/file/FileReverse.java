import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Formatter;

public class FileReverse
{
    public static void main(String[] args)
    {
        if (args.length < 2)
        {
            System.out.println("Error!! Arguments mismatch");
            return;
        }

        try
        {
            Scanner input = new Scanner(new File(args[0]));
            Formatter output = new Formatter(args[1]);

            while (input.hasNextLine())
            {
                String line = input.nextLine();
                String[] words = line.split("\\s+");

                String reversedLine = "";

                for (int i = words.length - 1; i >= 0; i--)
                {
                    reversedLine += words[i];

                    if (i != 0)
                    {
                        reversedLine += " ";
                    }
                }

                output.format("%s%n", reversedLine);
            }

            System.out.println("Operation Successful");

            input.close();
            output.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }
    }
}