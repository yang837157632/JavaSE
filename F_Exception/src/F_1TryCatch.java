/*
 * try...catch �Ǵ����쳣�����ַ���֮һ���ʺϴ������Ա���Կ��ƺ��û���������������
 * ���𵽳��򿪷�˳�����кͱ��ⲻ��Ҫ����ķ�����
 * 
 * Finally ��������쳣������ڵ����ã����� try...catch �������
 * �����Ƿ�����쳣��finally�е���䶼�ᱻִ�У��������Ը��õؿ��Ƴ��������
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
		//���������finally���п���
		finally
		{
			System.out.println("This is the end");
		}
	}

}
