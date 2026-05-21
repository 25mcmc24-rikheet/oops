import java.util.*;
public class complex
{   
	int real;
	int img;

	complex(int r,int i)
	{
		real=r;
		img=i;
	}
	complex add(complex c)
	{
		return new complex(real+c.real,img+c.img);

	}
	complex sub(complex c)
	{
		return new complex(real-c.real,img-c.img);
	}
	complex mul(complex c)
	{
		int r=real*c.real-img*c.img;
		int i=real*c.img+img*c.real;
		return new complex(r,i);
	}

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		int d=sc.nextInt();

		complex A=new complex(a,b);
		complex B=new complex(c,d);

		complex sum=A.add(B);
		complex diff=A.sub(B);
		complex prod=A.mul(B);

		System.out.println(sum.real+" "+sum.img+" "+diff.real+" "+diff.img+" "+prod.real+" "+prod.img);
	}
}

