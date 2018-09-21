import java.util.Scanner;
public class A_12Switch 
{
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		System.out.print("Please input you rank: ");
		int Rank=in.nextInt();
		switch(Rank)
		{
		case 1:
			System.out.println("Champion");
			break;
		case 2:
			System.out.println("Runner-up");
			break;
		case 3:
			System.out.println("Second Runner-up");
			break;
		default:
			System.out.println("Thank you for joining");
		}
	}

}
