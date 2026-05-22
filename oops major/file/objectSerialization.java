import java.io.*;
import java.util.*;

class Question implements Serializable
{
    private String question;
    private boolean answer;

    public Question(String question, boolean answer)
    {
        this.question = question;
        this.answer = answer;
    }

    public void setQues(String question)
    {
        this.question = question;
    }

    public void setAns(boolean answer)
    {
        this.answer = answer;
    }

    public String getQues()
    {
        return question;
    }

    public boolean getAns()
    {
        return answer;
    }
}

public class objectSerialization
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Create Question Bank");
        System.out.println("2. Take Test");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1)
        {
            createQuestionBank(sc);
        }
        else if (choice == 2)
        {
            takeTest(sc);
        }
        else
        {
            System.out.println("Invalid choice");
        }

        sc.close();
    }

    public static void createQuestionBank(Scanner sc)
    {
        try
        {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("questionbank.dat"));

            System.out.print("Enter number of questions: ");
            int n = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < n; i++)
            {
                System.out.print("Enter question: ");
                String ques = sc.nextLine();

                System.out.print("Enter answer in boolean format(true/false only accepted): ");
                boolean ans = sc.nextBoolean();
                sc.nextLine();

                Question object = new Question(ques, ans);
                out.writeObject(object);
            }

            out.close();
            System.out.println("Question bank created successfully!");
        }
        catch (IOException e)
        {
            System.out.println("File error");
        }
    }

    public static void takeTest(Scanner sc)
    {
        int score = 0;
        int total = 0;

        try
        {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("questionbank.dat"));

            while (true)
            {
                try
                {
                    Question ques = (Question) in.readObject();

                    System.out.println(ques.getQues());
                    System.out.print("Your answer (true/false): ");
                    boolean Ans = sc.nextBoolean();

                    if (Ans == ques.getAns())
                    {
                        System.out.println("Correct!");
                        score++;
                    }
                    else
                    {
                        System.out.println("Wrong! Correct answer: " + ques.getAns());
                    }

                    total++;
                }
                catch (EOFException e)
                {
                    break;
                }
            }

            in.close();
            System.out.println("Final Score: " + score + "/" + total);
        }
        catch (IOException | ClassNotFoundException e)
        {
            System.out.println("File error");
        }
    }
}