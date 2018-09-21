/*
 * abstract: ��һ�����η������������࣬����
 * �����Ƕ����������ƹ��ܣ������ܵ����岻ͬ����ʱ���ǽ������ϳ�ȡ����ֻ��ȡ���ܵĶ��岻��ȡ���ܵ�����
 * 
 * ��������ص�:
 * 1�����󷽷�һ��Ҫ�ڳ�������
 * 2��������ͳ��󷽷�����Ҫ��abstract�ؼ������Σ�abstractֻ��������ͺ���
 * 3����������ǲ��ܱ�����������Ϊ���ö���ķ���û����
 * 4���������еķ���Ҫ��ʹ�ã�������������д�������еķ��������Ҵ����������������
 * 5���������п��Զ���ǳ���ķ�������ʱ������Ҫ���಻�ܱ�new�ؼ��ִ�������ʱ��������abstract�������ɳ�����
 * 6���������ֻ��дһ���ֵĳ��з�������ô�����໹��һ�������ࡣ���������ķ���Ҫ��ʹ�ã����������д�������е����з���
 * 
 * ע��������������ͨ��û��̫��Ĳ�ͬ
 * 1���������޷�ͨ��new�ؼ��ִ�������
 * 2��������������г��󷽷�
 */

abstract class C_24Class
{
	abstract void rotate();
	void show()
	{
		System.out.println("Shining");
	}
}

class C_24_1 extends C_24Class
{
	void rotate()
	{
		System.out.println("Irregulal rotating");
	}
}

class C_24_2 extends C_24Class
{
	void rotate()
	{
		System.out.println("Eclipse rotating");
	}
}
public class C_24Abstract 
{
	public static void main(String[] args)
	{
		C_24Class X1=new C_24_1();
		C_24_2 X2=new C_24_2();
		X1.rotate();
		X1.show();
		X2.rotate();
		X2.show();
	}

}
