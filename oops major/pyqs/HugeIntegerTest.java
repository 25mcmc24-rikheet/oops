class HugeInteger
{
    int digits[];

    HugeInteger()
    {
        digits = new int[1];
        digits[0] = 0;
    }

    HugeInteger(String s)
    {
        digits = new int[s.length()];

        for(int i=0;i<s.length();i++)
        {
            digits[i] = s.charAt(i) - '0';
        }
    }

    boolean isEqualTo(HugeInteger b)
    {
        if(this.digits.length != b.digits.length)
            return false;

        for(int i=0;i<digits.length;i++)
        {
            if(this.digits[i] != b.digits[i])
                return false;
        }

        return true;
    }

    boolean isGreaterThan(HugeInteger b)
    {
        if(this.digits.length > b.digits.length)
            return true;

        if(this.digits.length < b.digits.length)
            return false;

        for(int i=0;i<digits.length;i++)
        {
            if(this.digits[i] > b.digits[i])
                return true;

            if(this.digits[i] < b.digits[i])
                return false;
        }

        return false;
    }

    void increment()
    {
        int carry = 1;

        for(int i=digits.length-1;i>=0;i--)
        {
            int sum = digits[i] + carry;

            digits[i] = sum % 10;

            carry = sum / 10;
        }

        if(carry!= 0)
        {
            int temp[] = new int[digits.length + 1];

            temp[0] = carry;

            for(int i=0;i<digits.length;i++)
            {
                temp[i+1] = digits[i];
            }

            digits = temp;
        }
    }

    public String toString()
    {
        String s = "";

        for(int i=0;i<digits.length;i++)
        {
            s += digits[i];
        }

        return s;
    }
}

public class HugeIntegerTest
{
    public static void main(String[] args)
    {
        HugeInteger a = new HugeInteger("999");
        HugeInteger b = new HugeInteger("1000");

        System.out.println("A = " + a);
        System.out.println("B = " + b);

        System.out.println("Equal : " + a.isEqualTo(b));

        System.out.println("A > B : " + a.isGreaterThan(b));

        a.increment();

        System.out.println("After increment A = " + a);
    }
}