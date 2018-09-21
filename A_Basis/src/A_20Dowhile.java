import java.util.*;

public class A_20Dowhile 
{
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		int sum=0;
		int i=0;
		do
		{
			System.out.print("Please input a number(end with 0): ");
			i=in.nextInt();
			sum+=i;
		}while(i!=0);
		System.out.println("Sum = "+sum);
	}

}
