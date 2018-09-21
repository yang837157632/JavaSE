import java.util.*;
public class B_10Calendar 
{
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		System.out.print("Please input the year: ");
		int year=in.nextInt();
		int ydays=0;
		System.out.print("Please input the month: ");
		int month=in.nextInt();
		int mdays=0;
		int days=0;
		for(int i=1900;i<=year;i++)
		{
			if(((i%4==0)&&(i%100!=0))||(i%400==0))
			{
				ydays=366;
			}else
			{
				ydays=365;
			}
			days+=ydays;
		}
		for(int i=0;i<=month;i++)
		{
			switch(i)
			{
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				mdays=31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				mdays=30;
				break;
			case 2:
				if(ydays==366)
				{
					mdays=29;
				}else
				{
					mdays=28;
				}
			}
			days+=mdays;
		}
		days=days-ydays-mdays+1;
		System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
		int n=days%7;
		for(int i=1;i<=n;i++)
		{
			System.out.print("\t");
		}
		System.out.print("1");
		for(int i=2;i<=mdays;i++)
		{
			days++;
			if(days%7!=0)
			{
				System.out.print("\t "+i+" ");
			}else
			{
				System.out.print("\n "+i+" ");
			}
		}
	}

}
