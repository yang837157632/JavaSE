/*
 * ��̬���������Ϊ������ڶ���������̬
 * ��̬�����֣����������������
 * ��̬��ǰ�᣺
 * ��1�������������֮����ڹ�ϵ������ʹ�̳й�ϵ��Ҳ������ʵ�ֹ�ϵ
 * ��2�����������д
 * ��̬�ĺô����������˳������չ��
 * ��̬�ı׶ˣ�ֻ���ø�������ã����ʵ������еĳ�Ա
 * ��̨��Ա�������ص㣺
 * ��1�������ڼ䣺���ĵ��������ͱ��������������Ƿ��е��õķ���
 * ��2�������ڼ䣺���Ķ��������������Ƿ��е��÷���
 */

class C_19Class
{
	void run()
	{
		System.out.println("Running");
	}
}

class C_19_1 extends C_19Class
{
	void run()
	{
		System.out.println("Running and jumping");
	}
}

class C_19_2 extends C_19Class
{
	void run()
	{
		System.out.println("Running and playing");
	}
}

class C_19_3 extends C_19Class{}

public class C_19Polymorphism 
{
	public static void main(String[] args)
	{
		C_19_1 S1=new C_19_1();
		function(S1);
		
		C_19_2 S2=new C_19_2();
		function(S2);
		
		C_19_3 S3=new C_19_3();
		function(S3);
	}
	
	public static void function(C_19Class S)
	{
		S.run();
	}

}
