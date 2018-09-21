import java.util.Scanner;
public class A_14 
{
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		System.out.print("Please input a year: ");
		int Year=in.nextInt();
		if((Year%4==0)&&(Year%100!=0)||(Year%400==0))
		{
			System.out.println("Year "+Year+" is a leap year");
		}else
		{
			System.out.println("Year "+Year+" is a common year");
		}
	}

}
