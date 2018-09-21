// in.next()	in.nextInt()	in.nextDouble()

import java.util.Scanner;
public class A_5Scanner 
{
	public static void main(String[] args)
	{
		Scanner A=new Scanner(System.in);
		System.out.print("Please input your name :");
		String Name=A.next();
		System.out.print("Please intput your age :");
		int Age=A.nextInt();
		System.out.print("Please input your gender £º");
		String Gender=A.next();
		System.out.print("Please input your grade :");
		double Grade=A.nextDouble();
		System.out.println("Name = "+Name);
		System.out.println("Age = "+Age);
		System.out.println("Gender = "+Gender);
		System.out.println("Grade = "+Grade);
	}

}
