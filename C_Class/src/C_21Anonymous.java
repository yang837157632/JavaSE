/*
 * ��������û�����ֵĶ���
 * ���������ʹ�÷�ʽ��
 * ��1��������ķ���ֻ����һ��ʱ�����ǿ������������������
 * ��2������������Ե���ʵ�δ���
 */

class C_21Class
{
	void eat()
	{
		System.out.println("Eating");
	}
	
	void sleep()
	{
		System.out.println("Sleeping");
	}
}

public class C_21Anonymous 
{
	public static void main(String[] args)
	{
		new C_21Class().eat();
		eg(new C_21Class());
	}
	
	public static void eg(C_21Class U)
	{
		U.sleep();
	}

}
