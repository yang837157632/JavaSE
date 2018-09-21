import java.util.Scanner;
public class A_18 
{
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		System.out.print("Please input the number: ");
		int num=in.nextInt();
		int i=1;
		int sum=0;
		while(i<=num)
		{
			sum+=i;
			i++;
		}
		System.out.println("1+2+...+"+num+" = "+sum);
	}

}
