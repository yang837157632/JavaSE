import java.util.Scanner;
public class A_9Ifelse 
{
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		System.out.print("Please input your value: ");
		int Value=in.nextInt();
		if(Value>80)
		{
			System.out.println("Good");
		}else
		{
			System.out.println("Bad");
		}
		System.out.println("If-else testing");
	}

}
