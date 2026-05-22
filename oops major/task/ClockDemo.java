class Clock
{
    int hour;
    int minute;
    int second;

    Clock()
    {
        this(0,0,0);
    }

    Clock(int h)
    {
        this(h,0,0);
    }

    Clock(int h,int m)
    {
        this(h,m,0);
    }

    Clock(int h,int m,int s)
    {
        setHour(h);
        setMinute(m);
        setSecond(s);
    }

    void setHour(int h)
    {
        if(h>=0 && h<24)
            hour = h;
        else
            hour = 0;
    }

    void setMinute(int m)
    {
        if(m>=0 && m<60)
            minute = m;
        else
            minute = 0;
    }

    void setSecond(int s)
    {
        if(s>=0 && s<60)
            second = s;
        else
            second = 0;
    }

    void tick()
    {
        second++;

        if(second == 60)
        {
            second = 0;
            minute++;

            if(minute == 60)
            {
                minute = 0;
                hour++;

                if(hour == 24)
                {
                    hour = 0;
                }
            }
        }
    }

    public String toString()
    {
        String h =
            (hour < 10) ? "0"+hour : ""+hour;

        String m =
            (minute < 10) ? "0"+minute : ""+minute;

        String s =
            (second < 10) ? "0"+second : ""+second;

        return h + ":" + m + ":" + s;
    }
}

public class ClockDemo
{
    public static void main(String[] args)
    {
        Clock c1 = new Clock();

        Clock c2 = new Clock(10);

        Clock c3 = new Clock(10,45);

        Clock c4 = new Clock(23,59,58);

        Clock c5 = new Clock(25,70,90);

        System.out.println(c1);

        System.out.println(c2);

        System.out.println(c3);

        System.out.println(c4);

        System.out.println(c5);

        System.out.println();

        c4.tick();

        System.out.println(c4);

        c4.tick();

        System.out.println(c4);
    }
}