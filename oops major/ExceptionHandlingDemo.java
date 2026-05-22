import java.util.*;

class InvalidMarksException extends Exception
{
    InvalidMarksException(String s)
    {
        super(s);
    }
}

class Student
{
    int marks;

    Student(int marks)
    {
        this.marks = marks;
    }

    void checkMarks()
        throws InvalidMarksException
    {
        if(marks < 0 || marks > 100)
        {
            throw new InvalidMarksException(
                "Marks should be between 0 and 100");
        }

        System.out.println(
            "Valid Marks");
    }

    void divide(int a,int b)
    {
        try
        {
            int x = a / b;

            System.out.println(
                "Result : " + x);
        }
        catch(ArithmeticException e)
        {
            System.out.println(
                "Division by zero");
        }
        finally
        {
            System.out.println(
                "Finally block executed");
        }
    }
}

public class ExceptionHandlingDemo
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        try
        {
            System.out.println(
                "Enter marks");

            int m = sc.nextInt();

            Student s = new Student(m);

            s.checkMarks();

            System.out.println(
                "Enter two numbers");

            int a = sc.nextInt();

            int b = sc.nextInt();

            s.divide(a,b);
        }
        catch(InputMismatchException e)
        {
            System.out.println(
                "Invalid Input Type");
        }
        catch(InvalidMarksException e)
        {
            System.out.println(
                e.getMessage());
        }
        catch(Exception e)
        {
            System.out.println(
                "Some Exception Occurred");
        }
        finally
        {
            System.out.println(
                "Program Ended");

            sc.close();
        }
    }
}