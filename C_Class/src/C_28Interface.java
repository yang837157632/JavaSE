/*
 * �ӿڣ�����˹��ܵ���չ�ԣ���Ϊ������������������֮�������ԣ���ϵ���̶ܳȣ�
 * 
 * �����ж�����Ƕ�����й��ԵĻ�������
 * �ӿ��ж��������չ����
 * 
 * �ӿںô�������ʵ�ֶ�ʵ�֣�Ҳ����һ�������ʵ�ֶ���ӿ�
 */

class C_28Class
{
	String name;
	int age;
}

interface C_28Inter
{
	public abstract void Sun();
}

class C_28_1 extends C_28Class implements C_28Inter
{
	public void Sun()
	{
		System.out.println("Sunning");
	}
}

class C_28_2 extends C_28Class {}

public class C_28Interface 
{
	public static void main(String[] args)
	{
		C_28_1 AB=new C_28_1();
		AB.Sun();
	}

}
