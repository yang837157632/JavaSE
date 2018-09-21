/*
 * try...catch 是处理异常的两种方法之一，适合处理程序员可以控制和用户输入有误的情况。
 * 以起到程序开发顺利进行和避免不必要情况的发生。
 * 
 * Finally 语句是起到异常处理出口的作用，用在 try...catch 语句的最后。
 * 无论是否出现异常，finally中的语句都会被执行，这样可以更好地控制程序的走向。
 */

import java.util.Scanner;
public class F_1TryCatch 
{
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		int a,b,c;
		try
		{
			System.out.print("Please input a: ");
			a=in.nextInt();
			System.out.print("Please input b: ");
			b=in.nextInt();
			c=a%b;
			System.out.println(a+" % "+b+" = "+c);
		}catch(Exception e)
		{
			System.out.println("Wrong Input");
		}
		//此类情况下finally可有可无
		finally
		{
			System.out.println("This is the end");
		}
	}

}
