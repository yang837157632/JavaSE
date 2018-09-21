import java.util.Scanner;
public class A_6Boolean 
{
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		System.out.print("Please input a number: ");
		int a=in.nextInt();
		System.out.print("Please input another number: ");
		int b=in.nextInt();
		boolean flag=(a==b);
		System.out.println(a+" = "+b+"\t"+flag);
	}

}
