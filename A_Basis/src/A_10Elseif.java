import java.util.Scanner;
public class A_10Elseif 
{
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		System.out.print("Please input your grade: ");
		int Grade=in.nextInt();
		if(Grade>=90)
		{
			System.out.println("Excellent");
		}else if(Grade>=80)
		{
			System.out.println("Good");
		}else if(Grade>=60)
		{
			System.out.println("Normal");
		}else
		{
			System.out.println("Failed");
		}
		System.out.println("If-else if testing");
	}

}
