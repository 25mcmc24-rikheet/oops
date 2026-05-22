import java.util.*;

public class pixelCompression
{
    static int quantize(int x)
    {
        if(x>=0 && x<=20)
            return 10;
        else if(x<=40)
            return 30;
        else if(x<=60)
            return 50;
        else if(x<=80)
            return 70;
        else if(x<=100)
            return 90;
        else if(x<=120)
            return 110;
        else if(x<=140)
            return 130;
        else if(x<=160)
            return 150;
        else if(x<=180)
            return 170;
        else
            return 190;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int arr[] = new int[n];

        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }

        int q[] = new int[n];

        for(int i=0;i<n;i++)
        {
            q[i] = quantize(arr[i]);
        }

        System.out.println("Quantized Array");

        for(int i=0;i<n;i++)
        {
            System.out.print(q[i] + " ");
        }

        System.out.println();

        System.out.println("Compressed Array");

        int count = 1;

        for(int i=0;i<n;i++)
        {
            if(i<n-1 && q[i]==q[i+1])
            {
                count++;
            }
            else
            {
                System.out.print(q[i] + " ");
                System.out.print(count + " ");
                count = 1;
            }
        }

        sc.close();
    }
}