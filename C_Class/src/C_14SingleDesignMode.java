/*
 * �������ģʽ�����һ����ֻ���ڴ��д���һ������
 * 
 * ���ģʽ����Դ�����������Ч�Ľ������
 * java����23�����ģʽ
 * 
 * �����һ�������ڴ���ֻ������һ������
 * 1����ֹ������Ӧ�ó���ͨ����������������
 * 2����Ȼ�ⲿ����ͨ�����ഴ�������ˣ�����Ҫ�ö��󣬾���Ҫ�ڱ������洴���������
 * 3��Ϊ������Ӧ�ó����ܹ����ʵ��������洴���Ķ�����Ҫ������ṩһ�ַ��ʷ�ʽ
 * 
 * ����ô�������ֳ�����
 * 1��˽�л����췽��
 * 2���ڱ����д����������
 * 3��������ṩ���ʵķ���
 */

class C_14Class
{
	String name;
	int age;
	
	private C_14Class(){}
	
	static C_14Class N=new C_14Class();
	
	public static C_14Class getInstance()
	{
		return N;
	}
}

public class C_14SingleDesignMode 
{
	public static void main(String[] args)
	{
		C_14Class N1=C_14Class.getInstance();
		N1.name="Bell";
		C_14Class N2=C_14Class.getInstance();
		N2.age=25;
		System.out.println(N2.name);
		System.out.println(N1.age);
	}
}
