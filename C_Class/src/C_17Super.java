/*
 * �Ӹ��๹�캯��
 * �����Ӹ���֮���캯�����ص㣺
 * �ڶ����������г�ʼ����ʱ�򣬸���Ĺ��췽��Ҳ��ִ�У�������Ϊ����Ĺ��췽��Ĭ�ϵ�һ����һ����ʽ�����super����
 * ����ÿ�����췽����һ�ж���һ����ʽ��super����
 */

class C_17Class
{
	String name;
	
	C_17Class()
	{
		System.out.println("�����޲ι��췽��");
	}
	
	C_17Class(String name)
	{
		this.name=name;
		System.out.println("�����вι��췽��");
	}
}

class C_17_1 extends C_17Class
{
	C_17_1()
	{
		super("ABC");
		System.out.println("�����޲ι��췽��");
	}
	
	C_17_1(String name)
	{
		System.out.println("�����вι��췽��");
	}
}

public class C_17Super 
{
	public static void main(String[] args)
	{
		C_17_1 Q1=new C_17_1();
		System.out.println();
		C_17_1 Q2=new C_17_1("XYZ");
	}

}
