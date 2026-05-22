class InvalidAgeException extends Exception
{
    InvalidAgeException(String s)
    {
        super(s);
    }
}

public class CustomExceptionDemo
{
    static void checkAge(int age)
        throws InvalidAgeException
    {
        if(age < 18)
        {
            throw new InvalidAgeException(
                "Age must be 18 or above");
        }

        System.out.println(
            "Eligible for voting");
    }

    public static void main(String[] args)
    {
        try
        {
            checkAge(15);
        }
        catch(InvalidAgeException e)
        {
            System.out.println(
                e.getMessage());
        }
    }
}