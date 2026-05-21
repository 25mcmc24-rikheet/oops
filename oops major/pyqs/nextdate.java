class Date
{
    int day;
    int month;
    int year;

    Date(int day,int month,int year)
    {
        this.day=day;
        this.month=month;
        this.year=year;
    }

    public String toString()
    {
        return this.day+"/"+this.month+"/"+this.year;
    }


public Date nextdate()
{
    int day1[]={31,28,31,30,31,30,31,31,30,31,30,31};
    if(leapyear())
        day1[1]=29;
    if(this.month==12 && this.day==day1[this.month-1])
        return new Date(1,1 ,this.year+1 );
    else if(this.day==day1[this.month-1])
        return new Date(1,this.month+1 ,this.year );
    else
        return new Date(this.day+1,this.month,this.year );
}

boolean validate()
{
    if(this.day<1 || this.month<1 || this.month>12 || this.year<0) 
        return false;
    int day1[]={31,28,31,30,31,30,31,31,30,31,30,31};
    if(leapyear())
        day1[1]=29;
    return this.day<=day1[this.month-1];
}

boolean leapyear()
{
    return (this.year%4==0 && this.year%100!=0) || this.year%400==0 ;
}
}

public class one
{
    public void main(String[] args) {
        Date d =new Date(30,2,2001 );
        if(!d.validate())
        {
            System.out.println("Invalid date");
            return;
            
        }
            System.out.println(d.nextdate());
    }
}