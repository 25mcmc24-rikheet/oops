import java.util.*;
public class rationalnumber
{
	static class Rational
	{
		int p,q;
		Rational(int p,int q)
		{
			this.p=p;
			this.q=q;
			simplify();
		}
		int gcd(int a,int b)
		{
			if(b==0)
				return Math.abs(a);
			return gcd(b,a%b);
		}
		void simplify()
		{
			if(p==0)
				return;
			int g=gcd(p,q);
			p/=g;
			q/=g;
			if(q<0)
			{
				p=-p;
				q=-q;
			}
		}

		static Rational add(Rational r1,Rational r2)
		{
			return new Rational(r1.p*r2.q+r2.p*r1.q,r1.q*r2.q);
		}

		static Rational sub(Rational r1,Rational r2)
		{
			return new Rational(r1.p*r2.q-r2.p*r1.q,r1.q*r2.q);
		}

		static Rational mul(Rational r1,Rational r2)
		{
			return new Rational(r1.p*r2.p,r1.q*r2.q);
		}
		static Rational div(Rational r1,Rational r2)
		{
			if(r2.p==0)
				return null;
			return new Rational(r1.p*r2.q,r1.q*r2.p);
		}

		public String toString()
		{
			return p+"/"+q;
		}
	}
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		int d=sc.nextInt();

		if(b==0||d==0)
		{
			System.out.println("INVALID INPUT");
			return;
		}

		Rational r1=new Rational(a,b);
		Rational r2=new Rational(c,d);

		Rational add=Rational.add(r1,r2);
		Rational sub=Rational.sub(r1,r2);
		Rational mul=Rational.mul(r1,r2);
		Rational div=Rational.div(r1,r2);

		System.out.print(r1+" ");
		System.out.print(r2+" ");
		System.out.print(add+" ");
		System.out.print(sub+" ");
		System.out.print(mul+" ");
		
		if(div==null)
			System.out.println("IVRN");
		else
			System.out.println(div);
	}
}
