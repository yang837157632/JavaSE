import java.util.Scanner;
public class A_11Ifif 
{
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		System.out.print("Sex(M/F):	");
		String Sex=in.next();
		if(Sex.equals("M"))
		{
			System.out.print("Please input your age: ");
			int Age=in.nextInt();
			if(Age>=18)
			{
				System.out.println("Welcome");
			}else
			{
				System.out.println("Minors Forbidden");
			}
		}else
		{
			System.out.println("Men Only");
		}
	}

}
