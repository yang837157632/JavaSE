/*
 * ���������ص㣺
 * ����һ�����������ˣ����������ڹ��캯��ִ��
 * ���ã���������г�ʼ����
 * 
 * ��������͹��췽��������
 * ��������Ƕ�Ӧ�Ķ�����г�ʼ��
 * ���������Ǹ����еĶ������ͳһ�ĳ�ʼ��
 */

class C_7Class
{
	String name;
	
	C_7Class()
	{
		System.out.println("�޲δ����\n");
	}
	
	C_7Class(String name)
	{
		this.name=name;
		System.out.println("�вδ����\n");
	}
	
	{
		System.out.println("��������");
	}
}
public class C_7Structure 
{
	public static void main(String[] args)
	{
		C_7Class G1=new C_7Class();
		C_7Class G2=new C_7Class("Klevin");
	}

}
