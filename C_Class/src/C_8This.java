/*
 * this���ã�
 * �������־ֲ������ͳ�Ա����֮��ͬ�������
 * �������󣬴��������ں������������������������
 * ���췽��֮��ĵ���ֻ��ͨ��this��������
 * ���캯��֮����е���ʱthis���ֻ�ܳ����ڵ�һ�У����췽��Ҫ��ִ��
 * ������췽�����л��г�ʼ�����Ǿ�ִ�и�ϸ�ڵĳ�ʼ��
 */

class C_8Class
{
	String name;
	int age;
	
	C_8Class()
	{
		System.out.println("�޲ι��췽��");
	}
	
	C_8Class(String name)
	{
		this();
		this.name=name;
		System.out.println(name);
	}
	
	C_8Class(String name,int age)
	{
		this(name);
		this.age=age;
		System.out.println(age);
	}
}

public class C_8This 
{
	public static void main(String[] args)
	{
		C_8Class H1=new C_8Class();
		System.out.println();
		
		C_8Class H2=new C_8Class("Jim");
		System.out.println();
		
		C_8Class H3=new C_8Class("Cal",34);
	}

}
