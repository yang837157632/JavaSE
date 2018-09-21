import java.util.*;
public class A_21 
{
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		Random R=new Random();
		int No=R.nextInt(100)+1;
		int i=1;
		do
		{
			System.out.print("please guess a number for "+i+ " time: ");
			int num=in.nextInt();
			if(No==num)
			{
				break;
			}else if(No<num)
			{
				System.out.println("Too larger");
			}else
			{
				System.out.println("Too smaller");
			}
			i++;			
		}while(i<=7);
		if(i<=7)
		{
			System.out.println("Bingo");
		}else
		{
			System.out.println("Try harder next time");
		}
	}

}
