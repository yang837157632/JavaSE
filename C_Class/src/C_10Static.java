/*
 * ʲôʱ��ʹ�þ�̬
 * static�����ε������ǳ�Ա��������������
 * 
 * ʲôʱ��ʹ�þ�̬�ĳ�Ա������
 * ������ͬһ������ж�����ֹ�������ʱ
 * ��Ҫ���洢����������ݵĳ�Ա������static����
 * 
 * ʲôʱ��ʹ�þ�̬������
 * �������ڲ�û�з��ʵ��Ǿ�̬�ĳ�Աʱ���������е����ݣ�
 * ��ô�ù��ܿ��Զ���Ϊ��̬��
 */

class C_10Class
{
	static void print()
	{
		System.out.println("hello");
	}
}

public class C_10Static 
{
	public static void main(String[] args)
	{
		C_10Class.print();
		C_10Class J1=new C_10Class();
		J1.print();
	}

}
