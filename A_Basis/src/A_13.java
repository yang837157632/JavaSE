import java.util.Scanner;
public class A_13 
{
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		System.out.print("Please input a number: ");
		int num=in.nextInt();
		switch(num/10)
		{
		case 10:
		case 9:
			System.out.println("Excellent");
			break;
		case 8:
		case 7:
			System.out.println("Good");
			break;
		case 6:
			System.out.println("Normal");
			break;
		default:
			System.out.println("Failed");
		}
	}

}
