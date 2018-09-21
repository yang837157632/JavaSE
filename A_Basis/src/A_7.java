import java.util.Scanner;
public class A_7 
{
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		System.out.print("Please input a: ");
		String a=in.next();
		System.out.print("Please input b: ");
		String b=in.next();
		System.out.println("Before swaping\ta = "+a+"\tb = "+b);
		String c=a;
		a=b;
		b=c;
		System.out.println("After swaping\ta = "+a+"\tb = "+b);
	}
	
}
