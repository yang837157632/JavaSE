/*
 * �Ӹ����Ա�ص�
 * ��Ա��
 * 1����Ա����
 * 2������
 * 3�����캯��
 * 
 * ������
 * this ����ǰ��������� 
 * this.���� �����ڱ�����������Ҫ��������������û���ҵ����ڸ�������
 * super ���ڷ��ʵ�ǰ����ĸ����Ա
 * super.name ֱ�Ӹ��������������
 * 
 * ����
 * �������г��ֺ͸���һ���ĺ���ʱ�����������øú���ʱ�����е��������еĺ�������ͬ�����еĺ���������һ��������������Ǻ�������һ�����ԣ���д/����
 * ���า�Ǹ���ʱ������Ҫ��֤����Ȩ�޴��ڵ��ڸ��࣬�ſ��Ը��ǣ�����������
 * ����Ȩ�����η���public>default>private ��Աǰ��û���κη���Ȩ�ޣ����η�Ĭ��Ȩ�޾���default
 * ��̬�ĺ���ֻ�ܸ��Ǿ�̬��
 * ���أ�ֻ�������ķ����Ĳ����б�
 * ��д���Ӹ��෽��Ҫһģһ��
 */

class C_16Class
{
	String name="Monkey";
	String color;
	void watch()
	{
		System.out.println("Watching");
	}
}

class C_16_1 extends C_16Class
{
	String name="Golden Monkey";
	void print()
	{
		System.out.println(this.name);
		System.out.println(super.name);
	}
}

class C_16_2 extends C_16Class
{
	void watch()
	{
		color="Black";
		System.out.println(color+"\t watching");
	}
}

public class C_16This 
{
	public static void main(String[] args)
	{
		C_16_1 P1=new C_16_1();
		P1.print();
		P1.watch();
		
		C_16_2 P2=new C_16_2();
		P2.watch();
	}

}
