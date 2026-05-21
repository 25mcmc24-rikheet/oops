import java.util.Scanner;
public class date
{
	int day;
	int month;
	int year; 
	public static boolean leapyear(int year)
	{
		if((year%4==0&&year%100!=0)||(year%400==0))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public date(int day,int month,int year)
	{
		if(is_valid_date(day,month,year))
		{
			this.day=day;
			this.month=month;
			this.year=year;
		}
		else
		{
			this.day=0;
			this.month=0;
			this.year=0;
			System.out.println("INVALID DATE");
		}
	}
	
	public int getDay()
	{
		return day;
	}
	public int getMonth()
	{
		return month;
	}
	public int getYear()
	{
		return year;
	}

	public int compare(date d)
	{
		if(year!=d.year)
			return year<d.year?-1:1;
		if(month!=d.month)
			return month<d.month?-1:1;
		if(day!=d.day)
			return day<d.day?-1:1;
		return 0;
	}

	public String formatDMY()
	{
		return day + "/" + month + "/" + year;
	}
	public String formatMDY()
	{
		return month + "/" + day + "/" + year;
	}

	public int dayCount()
	{
		int[] days={31,28,31,30,31,30,31,31,30,31,30,31};
		if(leapyear(year))
			days[1]=29;
		int total=0;
		for(int i=0;i<month-1;i++)
		{
			total+=days[i];
		}
		return total+day;
	}

	private boolean is_valid_date(int day,int month,int year)
	{
		if(year<=0||month<1||month>12||day<1)
			return false;
		int[] days={31,28,31,30,31,30,31,31,30,31,30,31};
		if(leapyear(year))
			days[1]=29;
		return day<=days[month-1];
	}

	public boolean is_invalid()
	{
		return day==0&&month==0&&year==0;
	}

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int d1=sc.nextInt();
		int m1=sc.nextInt();
		int y1=sc.nextInt();

		int d2=sc.nextInt();
		int m2=sc.nextInt();
		int y2=sc.nextInt();

		date date1=new date(d1,m1,y1);
		date date2=new date(d2,m2,y2);

		if (date1.is_invalid() || date2.is_invalid())
		{
			
			return;
		}
		       

	System.out.print(date1.formatDMY() + " ");
        System.out.print(date2.formatMDY() + " ");
        System.out.print(date1.compare(date2) + " ");
        System.out.print(date1.dayCount() + " ");
        System.out.print(date2.dayCount());	
	}
}
