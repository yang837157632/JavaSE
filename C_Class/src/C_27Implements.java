/*
 * java��֧�ֶ�̳У���Ϊ���ڰ�ȫ�������������ж�������ͬ���ܣ��������ݲ�ͬʱ�����಻ȷ��Ҫ������һ��
 * ����java���������ֻ��ƣ�������һ��������ʽ����ɱ�ʾ������ʵ��
 * 
 * ��ϵ:
 * ������֮�䣺�̳й�ϵ
 * �ӿ�����֮�䣺ʵ�ֹ�ϵ
 * �ӿ���ӿ�֮�䣺�̳й�ϵ
 */

interface C_27Inter
{
	public abstract int bloom(int age);
}

interface C_27_1 extends C_27Inter
{
	public abstract void action();
}

interface C_27_2 extends C_27Inter
{
	public abstract void speak();
}

class C_27Class implements C_27_1,C_27_2
{
	public int bloom(int age)
	{
		return age;
	}
	
	public void action()
	{
		System.out.println("Action");
	}
	
	public void speak()
	{
		System.out.println("Speaking");
	}
}

public class C_27Implements 
{
	public static void main(String[] args)
	{
		C_27Class AA=new C_27Class();
		int age=AA.bloom(5);
		System.out.println("It took "+age+" years to bloom!\n");
		AA.action();
		AA.speak();		
	}

}
