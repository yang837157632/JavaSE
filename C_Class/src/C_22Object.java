/*
 * һ���������
 * Object������java�����ж����ֱ�ӻ��Ӹ��࣬�����࣬����
 * �����涨��Ĺ��������ж���Ӧ�þ߱���
 * ������һ������ʱ��û��ָ��Ҫ�̳�ĳ�࣬��Ĭ�ϼ̳�Object��
 * 
 *  ==��Object�����equals��ʵ�Ƚϵľ�����������ڴ��ַ�Ƿ�һ��
 */

class C_22Class {}

class C_22_1 extends C_22Class
{
	String name;
	
	public boolean equals(Object V)
	{
		if(V instanceof C_22_1)
		{
			return true;
		}else
		{
			return false;
		}
	}
}

class C_22_2 extends C_22Class {}

public class C_22Object 
{
	public static void main(String[] args)
	{
		System.out.println(new C_22_1());		//toString
		C_22_1 V1=new C_22_1();
		C_22_1 V2=new C_22_1();
		C_22_2 V3=new C_22_2();
		System.out.println(V1.equals(V2));
		System.out.println(V1.equals(V3));
	}

}
