/*
 * throws是处理异常的两种方法之一，他的处理方法是将异常抛给上一级处理。
 * 如都不能处理，最终抛给虚拟机处理，这个过程我们称为抛异常。
 */

import java.util.Scanner;
class F_2Class
{
	Scanner in=new Scanner(System.in);
	
	void division() throws Exception
	{
		System.out.print("Please input a (Dividend): ");
		int a=in.nextInt();
		System.out.print("Please input b (Divisor): ");
		int b=in.nextInt();
		int c=a%b;
		System.out.println(a+" % "+b+" = "+c);
	}
}
public class F_2Throws 
{
	public static void main(String[] args) throws Exception
	{
		F_2Class B=new F_2Class();
		B.division();
		System.out.println("This is the end");
	}

}
