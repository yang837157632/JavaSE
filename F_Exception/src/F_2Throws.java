/*
 * throws�Ǵ����쳣�����ַ���֮һ�����Ĵ������ǽ��쳣�׸���һ������
 * �綼���ܴ��������׸��������������������ǳ�Ϊ���쳣��
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
