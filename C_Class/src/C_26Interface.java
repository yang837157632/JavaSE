/*
 * �ӿڣ�������⣬�ӿ���һ������ĳ����࣬����������ȫ���ǳ��󷽷�ʱ������ͨ���ӿڵ���ʽ������
 * class���ڶ����࣬interface���ڶ���ӿ�
 * 
 * �ӿ��г�Ա�ĸ�ʽ��
 * 1��public static final String NAME="Star";		ȫ�ֳ���
 * 2��public abstract void show();					���󷽷�
 * 
 * ע�⣺
 * 1���ӿ���ֻ�ܳ���public�������η�
 * 2���ӿ��в����Դ���������Ϊ�����г��󷽷�����Ҫ������ʵ�֣�����Խӿ�������г��󷽷�ʵ�ֺ�������ܹ�ʵ�����������������һ��������
 */

interface C_26Inter
{
	public static final String NAME="Star";
	public abstract void show();
}

class C_26_1 implements C_26Inter
{
	public void show()
	{
		System.out.println("Leap Year");
	}
}

public class C_26Interface 
{
	public static void main(String[] args)
	{
		C_26_1 Z1=new C_26_1();
		System.out.println(Z1.NAME);
		Z1.show();
		System.out.println(C_26_1.NAME);
		System.out.println(C_26Inter.NAME);
	}
}
